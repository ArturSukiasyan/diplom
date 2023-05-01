package com.diplom.service.minio.impl;

import com.diplom.dto.minio.FileResponse;
import com.diplom.service.minio.FileStorageService;
import com.diplom.service.minio.MinioService;
import io.minio.errors.MinioException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Date;


@Service
@RequiredArgsConstructor
@Slf4j
public class FileStorageServiceImpl implements FileStorageService {

    private final MinioService minioService;

    @Override
    public FileResponse addFile(MultipartFile file) {
        String filename = file.getOriginalFilename() != null ? file.getOriginalFilename() : file.getName();
        Path path = Path.of(filename);
        try {
            minioService.upload(path, file.getInputStream(), file.getContentType());
            var metadata = minioService.getMetadata(path);
            log.info("this file {} storage in bucket: {} ", filename, metadata.bucket());
            return FileResponse.builder()
                    .filename(metadata.object())
                    .fileSize(metadata.size())
                    .contentType(metadata.contentType())
                    .createdTime(Date.from(metadata.lastModified().toInstant()))
                    .build();
        } catch (IOException | MinioException ex) {
            throw new IllegalStateException(ex.getMessage());
        }
    }

    @SneakyThrows
    @Override
    public void deleteFile(String filename) {
        Path path = Path.of(filename);
        var metadata = minioService.getMetadata(path);
        minioService.remove(path);
        log.info("this file {} removed in bucket: {} ", filename, metadata.bucket());
    }

    @SneakyThrows
    @Override
    public FileResponse getFile(String filename) {
        Path path = Path.of(filename);
        var metadata = minioService.getMetadata(path);

        InputStream inputStream = minioService.get(path);
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);

        return FileResponse.builder()
                .filename(metadata.object())
                .fileSize(metadata.size())
                .contentType(metadata.contentType())
                .createdTime(Date.from(metadata.lastModified().toInstant()))
                .stream(inputStreamResource)
                .build();
    }
}
