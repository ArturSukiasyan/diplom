package com.diplom.mapper.employee;

import com.diplom.dto.employee.request.EducationRequestDto;
import com.diplom.dto.employee.response.EducationResponseDto;
import com.diplom.entity.employee.Education;
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
