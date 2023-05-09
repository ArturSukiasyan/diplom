package com.diplom.controller;

import com.diplom.dto.minio.FileResponse;
import com.diplom.service.minio.FileStorageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "File")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/file")
public class FileController {

    private final FileStorageService fileStorageService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FileResponse> fileUpload(@RequestPart("file") MultipartFile file) {
        FileResponse response = fileStorageService.addFile(file);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/view/{file}")
    @ResponseStatus(HttpStatus.OK)
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
    public Object removeFile(@PathVariable String file) {
        fileStorageService.deleteFile(file);
        return ResponseEntity.noContent();
    }
}
