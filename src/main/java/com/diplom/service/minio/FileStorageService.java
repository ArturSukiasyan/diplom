package com.diplom.service.minio;

import com.diplom.dto.minio.FileResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    FileResponse addFile(MultipartFile multipartFile);

    void deleteFile(String fileName);

    FileResponse getFile(String fileName);
}
