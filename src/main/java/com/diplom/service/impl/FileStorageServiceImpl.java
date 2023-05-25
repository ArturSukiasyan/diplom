package com.diplom.service.impl;

import com.diplom.dto.minio.FileResponse;
import com.diplom.exception.MessageDoesNotSendException;
import com.diplom.service.DoctorService;
import com.diplom.service.EmailService;
import com.diplom.service.FileStorageService;
import com.diplom.service.MinioService;
import com.diplom.service.PatientService;
import io.minio.errors.MinioException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Date;

import static com.diplom.enums.EmailConstans.DOCUMENT_FROM_DOCTOR;


@Service
@RequiredArgsConstructor
@Slf4j
public class FileStorageServiceImpl implements FileStorageService {

    private final MinioService minioService;
    private final EmailService emailService;
    private final PatientService patientService;
    private final DoctorService doctorService;

    @Override
    public FileResponse addFile(MultipartFile file, String fileName, Long pid, Long did) {
        String filename = fileName != null ? fileName :
                          file.getOriginalFilename() != null ? file.getOriginalFilename() :
                          file.getName();
        Path path = Path.of(filename);
        try {
            minioService.upload(path, file.getInputStream(), file.getContentType());
            var metadata = minioService.getMetadata(path);
            log.info("this file {} storage in bucket: {} ", filename, metadata.bucket());
            sendFileToPatient(file, pid, did);
            return FileResponse.builder()
                .filename(metadata.object())
                .fileSize(metadata.size())
                .contentType(metadata.contentType())
                .createdTime(Date.from(metadata.lastModified().toInstant()))
                .build();
        } catch (IOException | MinioException ex) {
            throw new IllegalStateException(ex.getMessage());
        } catch (MessagingException e) {
            log.error(e.getMessage());
            throw new MessageDoesNotSendException();
        }
    }

    private void sendFileToPatient(MultipartFile file, Long pid, Long did) throws MessagingException {
        var patient = patientService.getById(pid);
        var doctor = doctorService.getById(did);
        String subject = DOCUMENT_FROM_DOCTOR + " - " + doctor.getFirstName() + " " + doctor.getLastName();
        String message = "PLease see attached file from doctor";
        emailService.sendMessageWithAttachment(patient.getEmail(), subject, message, file);

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
