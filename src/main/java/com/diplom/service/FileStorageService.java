package com.diplom.service;

import com.diplom.dto.minio.FileResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    FileResponse addFile(MultipartFile file, String fileName, Long pid, Long did);

    void deleteFile(String fileName);

    FileResponse getFile(String fileName);
}
