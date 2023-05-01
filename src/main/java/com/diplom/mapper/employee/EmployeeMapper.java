package com.diplom.mapper.employee;

import com.diplom.dto.employee.request.EmployeeCreateRequestDto;
import com.diplom.dto.employee.request.EmployeeUpdateRequestDto;
import com.diplom.dto.employee.response.EmployeeResponseDto;
import com.diplom.entity.employee.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        injectionStrategy = InjectionStrategy.FIELD,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        uses = {CertificateMapper.class, EducationMapper.class, ExperienceMapper.class, LanguageMapper.class})
public interface EmployeeMapper {

    EmployeeResponseDto entityToDto(Employee employee);

    Employee dtoToEntity(EmployeeCreateRequestDto dto);

    Employee dtoToEntity(EmployeeUpdateRequestDto dto);
}
