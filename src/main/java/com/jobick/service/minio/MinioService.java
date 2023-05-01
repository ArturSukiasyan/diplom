package com.jobick.service.minio;

import io.minio.Result;
import io.minio.StatObjectResponse;
import io.minio.errors.MinioException;
import io.minio.messages.Item;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface MinioService {
    List<Item> list();

    List<Item> fullList() throws MinioException;

    List<Item> list(Path path);

    List<Item> getFullList(Path path);

    List<Item> getItems(Iterable<Result<Item>> myObjects);

    InputStream get(Path path) throws MinioException;

    StatObjectResponse getMetadata(Path path) throws MinioException;

    void upload(Path source, InputStream file, String contentType, Map<String, String> headers) throws MinioException;

    void upload(Path source, InputStream file, String contentType) throws MinioException;

    void remove(Path source) throws MinioException;
}
