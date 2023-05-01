package com.diplom.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties("spring.minio")
public class MinioConfigurationProperties {
    private String url;
    private String accessKey;
    private String secretKey;
    private String bucket;
    private boolean secure = false;
    private String metricName = "minio.storage";
    private Duration connectTimeout = Duration.ofSeconds(10L);
    private Duration writeTimeout = Duration.ofSeconds(60L);
    private Duration readTimeout = Duration.ofSeconds(10L);
    private boolean checkBucket = true;
    private boolean createBucket = true;
}
