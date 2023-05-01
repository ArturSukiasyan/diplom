package com.jobick.dto.employee.request;

import com.jobick.dto.employee.CertificateDto;
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
