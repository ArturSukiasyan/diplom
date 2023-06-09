package com.diplom.mapper;

import com.diplom.dto.subclasses.request.create.EducationCreateRequestDto;
import com.diplom.dto.subclasses.request.update.EducationUpdateRequestDto;
import com.diplom.dto.subclasses.response.EducationResponseDto;
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

    Education dtoToEntity(EducationCreateRequestDto dto);

    Education dtoToEntity(EducationUpdateRequestDto dto);
}
