package com.diplom.mapper.doctor;

import com.diplom.dto.doctor.request.EducationRequestDto;
import com.diplom.dto.doctor.response.EducationResponseDto;
import com.diplom.entity.Education;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        injectionStrategy = InjectionStrategy.FIELD,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface EducationMapper {

    EducationResponseDto entityToDto(Education education);

    Education dtoToEntity(EducationRequestDto dto);
}
