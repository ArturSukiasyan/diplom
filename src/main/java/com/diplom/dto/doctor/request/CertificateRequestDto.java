package com.diplom.dto.doctor.request;

import com.diplom.dto.doctor.CertificateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CertificateRequestDto extends CertificateDto {

    @NotNull(message = "{certificate.mandatory.file}")
    private MultipartFile file;
}
