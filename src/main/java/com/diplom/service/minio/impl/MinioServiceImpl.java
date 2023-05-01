package com.diplom.service.minio.impl;


import com.diplom.config.MinioConfigurationProperties;
import com.diplom.exception.MinioFetchException;
import com.diplom.service.minio.MinioService;
import io.minio.GetObjectArgs;
import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.Result;
import io.minio.StatObjectArgs;
import io.minio.StatObjectResponse;
import io.minio.errors.MinioException;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.diplom.enums.Constants.MINIO_ERROR_MESSAGE;

@Service
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {

    private final MinioClient minioClient;
    private final MinioConfigurationProperties properties;

    @Override
    public List<Item> list() {
        Iterable<Result<Item>> myObjects = minioClient.listObjects(ListObjectsArgs.builder()
                .bucket(properties.getBucket())
                .prefix("")
                .recursive(false)
                .build());
        return getItems(myObjects);
    }

    @Override
    public List<Item> fullList() throws MinioException {
        Iterable<Result<Item>> myObjects = minioClient.listObjects(ListObjectsArgs.builder()
                .bucket(properties.getBucket())
                .build());
        return getItems(myObjects);
    }

    @Override
    public List<Item> list(Path path) {
        Iterable<Result<Item>> myObjects = minioClient.listObjects(ListObjectsArgs.builder()
                .bucket(properties.getBucket())
                .prefix(path.toString())
                .recursive(false)
                .build());
        return getItems(myObjects);
    }

    @Override
    public List<Item> getFullList(Path path) {
        Iterable<Result<Item>> myObjects = minioClient.listObjects(ListObjectsArgs.builder()
                .bucket(properties.getBucket())
                .prefix(path.toString())
                .build());
        return getItems(myObjects);
    }

    @Override
    public List<Item> getItems(Iterable<Result<Item>> myObjects) {
        return StreamSupport.stream(myObjects.spliterator(), true)
                .map(MinioServiceImpl::getItem)
                .collect(Collectors.toList());
    }

    @Override
    public InputStream get(Path path) throws MinioException {

        try {
            return minioClient.getObject(GetObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(path.toString())
                    .build());
        } catch (InvalidKeyException | IOException | NoSuchAlgorithmException e) {
            throw new MinioException(MINIO_ERROR_MESSAGE, e.toString());
        }

    }

    @Override
    public StatObjectResponse getMetadata(Path path) throws MinioException {
        try {
            return minioClient.statObject(StatObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(path.toString())
                    .build());
        } catch (InvalidKeyException | IOException | NoSuchAlgorithmException e) {
            throw new MinioException(MINIO_ERROR_MESSAGE, e.toString());
        }

    }

    @Override
    public void upload(Path source, InputStream file, String contentType, Map<String, String> headers) throws MinioException {
        try {
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .contentType(contentType)
                    .object(source.toString())
                    .stream(file, file.available(), -1)
                    .headers(headers)
                    .build());
        } catch (InvalidKeyException | IOException | NoSuchAlgorithmException e) {
            throw new MinioException(MINIO_ERROR_MESSAGE, e.toString());
        }
    }

    @Override
    public void upload(Path source, InputStream file, String contentType) throws MinioException {
        upload(source, file, contentType, null);
    }

    @Override
    public void remove(Path source) throws MinioException {
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(properties.getBucket())
                    .object(source.toString())
                    .build());
        } catch (InvalidKeyException | IOException | NoSuchAlgorithmException e) {
            throw new MinioException(MINIO_ERROR_MESSAGE, e.toString());
        }
    }

    private static Item getItem(Result<Item> itemResult) {
        try {
            return itemResult.get();
        } catch (NoSuchAlgorithmException | IOException | InvalidKeyException | MinioException e) {
            throw new MinioFetchException("Error while parsing list of objects", e);
        }
    }

}
