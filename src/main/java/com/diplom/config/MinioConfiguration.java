package com.diplom.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Configuration
@ConditionalOnClass({MinioClient.class})
@EnableConfigurationProperties({MinioConfigurationProperties.class})
@ComponentScan({"com.diplom.config"})
@RequiredArgsConstructor
public class MinioConfiguration {

    private final MinioConfigurationProperties properties;

    @Bean
    public MinioClient minioClient() throws MinioException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(properties.getUrl())
                .credentials(properties.getAccessKey(), properties.getSecretKey())
                .build();
        minioClient.setTimeout(properties.getConnectTimeout().toMillis(),
                properties.getWriteTimeout().toMillis(),
                properties.getReadTimeout().toMillis());

        if (properties.isCheckBucket()) {
            try {
                log.debug("Checking if bucket {} exists", properties.getBucket());
                if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(properties.getBucket()).build())) {
                    if (!properties.isCreateBucket()) {
                        throw new MinioException(properties.getBucket(), "Bucket does not exists");
                    }
                    createBucket(minioClient);
                }
            } catch (NoSuchAlgorithmException | IOException | InvalidKeyException | MinioException ex) {
                log.error("Error while checking bucket", ex);
                throw ex;
            }
        }

        return minioClient;
    }

    private void createBucket(MinioClient minioClient) throws MinioException {
        try {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(properties.getBucket()).build());
        } catch (MinioException | InvalidKeyException | IOException | NoSuchAlgorithmException e) {
            throw new MinioException("Cannot create bucket", e.toString());
        }
    }
}

