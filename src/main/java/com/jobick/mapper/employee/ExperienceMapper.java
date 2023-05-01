package com.jobick.mapper.employee;

import com.jobick.dto.employee.request.ExperienceRequestDto;
import com.jobick.dto.employee.response.ExperienceResponseDto;
import com.jobick.entity.employee.Experience;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        injectionStrategy = InjectionStrategy.FIELD,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface ExperienceMapper {

    ExperienceResponseDto entityToDto(Experience experience);

    Experience dtoToEntity(ExperienceRequestDto dto);

}
