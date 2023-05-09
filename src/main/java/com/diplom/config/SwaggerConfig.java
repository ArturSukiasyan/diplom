package com.diplom.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("swagger")
public class SwaggerConfig {

    public static final String TITLE = "Medical Portal";
    public static final String VERSION = "v1";
    public static final String SECURITY_SCHEMA_NAME = "Authentication";
    public static final String EMAIL = "sukiasyan.99.99@gmail.com";
    public static final String APP_URL = "http://localhost:8585/med-portal/api";

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(info())
            .addServersItem(server());
    }

    private Info info() {
        return new Info()
            .contact(new Contact().email(EMAIL))
            .title(TITLE)
            .version(VERSION);
    }

    private Server server() {
        Server server = new Server();
        server.setUrl(APP_URL);
        return server;
    }
}
