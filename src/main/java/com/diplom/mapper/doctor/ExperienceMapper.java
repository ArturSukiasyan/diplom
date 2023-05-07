package com.diplom.mapper.doctor;

import com.diplom.dto.doctor.request.create.ExperienceCreateRequestDto;
import com.diplom.dto.doctor.response.ExperienceResponseDto;
import com.diplom.entity.Experience;
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

    Experience dtoToEntity(ExperienceCreateRequestDto dto);

}
