package com.jobick.dto.employee.response;

import com.jobick.dto.employee.CertificateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CertificateResponseDto extends CertificateDto {

    private Long id;

    private byte[] file;

}
