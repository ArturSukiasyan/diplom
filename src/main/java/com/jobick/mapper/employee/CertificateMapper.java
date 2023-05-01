package com.jobick.mapper.employee;

import com.jobick.dto.employee.request.CertificateRequestDto;
import com.jobick.dto.employee.response.CertificateResponseDto;
import com.jobick.entity.employee.Certificate;
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
