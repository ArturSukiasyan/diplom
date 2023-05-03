package com.diplom.dto.doctor.response;

import com.diplom.dto.doctor.CertificateDto;
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
