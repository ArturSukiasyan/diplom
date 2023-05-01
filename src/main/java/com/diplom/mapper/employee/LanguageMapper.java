package com.diplom.mapper.employee;

import com.diplom.dto.employee.request.LanguageRequestDto;
import com.diplom.dto.employee.response.LanguageResponseDto;
import com.diplom.entity.employee.Language;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        injectionStrategy = InjectionStrategy.FIELD,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface LanguageMapper {

    LanguageResponseDto entityToDto(Language language);

    Language dtoToEntity(LanguageRequestDto dto);

}
