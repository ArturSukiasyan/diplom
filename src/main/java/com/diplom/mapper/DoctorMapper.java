package com.diplom.mapper;

import com.diplom.dto.doctor.request.DoctorCreateRequestDto;
import com.diplom.dto.doctor.request.DoctorUpdateRequestDto;
import com.diplom.dto.doctor.response.DoctorResponseDto;
import com.diplom.entity.Doctor;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        injectionStrategy = InjectionStrategy.FIELD,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        uses = {CertificateMapper.class, EducationMapper.class, ExperienceMapper.class})
public interface DoctorMapper {

    DoctorResponseDto entityToDto(Doctor doctor);

    Doctor dtoToEntity(DoctorCreateRequestDto dto);

    Doctor dtoToEntity(DoctorUpdateRequestDto dto);
}
