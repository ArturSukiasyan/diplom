package com.diplom.controller;

import com.diplom.dto.minio.FileResponse;
import com.diplom.service.FileStorageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@RestController
@Tag(name = "File")
@RequiredArgsConstructor
@RequestMapping(value = "/file")
public class FileController {

    private final FileStorageService fileStorageService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('DOCTOR')")
    @Secured({"ROLE_DOCTOR"})
    public ResponseEntity<FileResponse> fileUpload(@RequestPart("file") MultipartFile file, String fileName,
                                                   @NotNull Long pid, @NotNull Long did) {
        FileResponse response = fileStorageService.addFile(file, fileName, pid, did);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/view/{file}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR','ROLE_PATIENT')")
    @Secured({"ROLE_DOCTOR", "ROLE_PATIENT"})
    public ResponseEntity<InputStreamResource> viewFile(@PathVariable String file) {
        FileResponse source = fileStorageService.getFile(file);
        return ResponseEntity
            .ok()
            .contentType(MediaType.parseMediaType(source.getContentType()))
            .contentLength(source.getFileSize())
            .header("Content-disposition", "attachment; filename=" + source.getFilename())
            .body(source.getStream());
    }

    @GetMapping("/download/{file}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAnyRole('ROLE_DOCTOR','ROLE_PATIENT')")
    @Secured({"ROLE_DOCTOR", "ROLE_PATIENT"})
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable String file) {
        FileResponse source = fileStorageService.getFile(file);
        return ResponseEntity
            .ok()
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .contentLength(source.getFileSize())
            .header("Content-disposition", "attachment; filename=" + source.getFilename())
            .body(source.getStream());
    }

    @DeleteMapping("/{file}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('DOCTOR')")
    @Secured({"ROLE_DOCTOR"})
    public Object removeFile(@PathVariable String file) {
        fileStorageService.deleteFile(file);
        return ResponseEntity.noContent();
    }
}
