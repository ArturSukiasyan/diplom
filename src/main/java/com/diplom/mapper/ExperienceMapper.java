package com.diplom.mapper;

import com.diplom.dto.subclasses.request.create.ExperienceCreateRequestDto;
import com.diplom.dto.subclasses.response.ExperienceResponseDto;
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
