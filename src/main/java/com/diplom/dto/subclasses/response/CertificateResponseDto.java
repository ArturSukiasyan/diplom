package com.diplom.dto.subclasses.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CertificateResponseDto {

    private Long id;
    private byte[] file;
    private String title;
    private String description;

}
