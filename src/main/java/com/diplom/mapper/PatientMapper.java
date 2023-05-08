package com.diplom.mapper;

import com.diplom.dto.patient.request.PatientCreateRequestDto;
import com.diplom.dto.patient.request.PatientUpdateRequestDto;
import com.diplom.dto.patient.response.PatientResponseDto;
import com.diplom.entity.Patient;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        injectionStrategy = InjectionStrategy.FIELD,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PatientMapper {

    PatientResponseDto entityToDto(Patient patient);

    Patient dtoToEntity(PatientCreateRequestDto dto);

    Patient dtoToEntity(PatientUpdateRequestDto dto);
}
