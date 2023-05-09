package com.diplom.dto.subclasses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public abstract class CertificateRequestDto {

    @NotNull(message = "{certificate.mandatory.file}")
    private MultipartFile file;

    @NotBlank(message = "{mandatory.title}")
    @Size(max = 50, message = "{invalid.title}")
    private String title;

    @Nullable
    @Size(max = 250, message = "{invalid.description}")
    private String description;
}
