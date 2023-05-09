package com.diplom.mapper;

import com.diplom.dto.subclasses.request.create.CertificateCreateRequestDto;
import com.diplom.dto.subclasses.response.CertificateResponseDto;
import com.diplom.entity.Certificate;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        injectionStrategy = InjectionStrategy.FIELD,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface CertificateMapper {

    CertificateResponseDto entityToDto(Certificate certificate);

    Certificate dtoToEntity(CertificateCreateRequestDto dto);

}
