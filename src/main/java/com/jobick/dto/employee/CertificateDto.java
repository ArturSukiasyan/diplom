package com.jobick.dto.employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public abstract class CertificateDto {

    @NotBlank(message = "{mandatory.title}")
    @Size(max = 50, message = "{invalid.title}")
    private String title;

    @Nullable
    @Size(max = 250, message = "{invalid.description}")
    private String description;

}
