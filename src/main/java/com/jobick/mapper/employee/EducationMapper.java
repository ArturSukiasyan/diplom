package com.jobick.mapper.employee;

import com.jobick.dto.employee.request.EducationRequestDto;
import com.jobick.dto.employee.response.EducationResponseDto;
import com.jobick.entity.employee.Education;
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
