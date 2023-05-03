package com.diplom.mapper.doctor;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        injectionStrategy = InjectionStrategy.FIELD,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PatientMapper {

//    EmployeeResponseDto entityToDto(Employee employee);
//
//    Employee dtoToEntity(EmployeeCreateRequestDto dto);
//
//    Employee dtoToEntity(EmployeeUpdateRequestDto dto);
}
