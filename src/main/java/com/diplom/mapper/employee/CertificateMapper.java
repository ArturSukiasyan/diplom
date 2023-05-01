package com.diplom.mapper.employee;

import com.diplom.dto.employee.request.CertificateRequestDto;
import com.diplom.dto.employee.response.CertificateResponseDto;
import com.diplom.entity.employee.Certificate;
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

    Certificate dtoToEntity(CertificateRequestDto dto);

}
