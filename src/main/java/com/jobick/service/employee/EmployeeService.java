package com.jobick.service.employee;

import com.jobick.dto.employee.request.EmployeeCreateRequestDto;
import com.jobick.dto.employee.response.EmployeeResponseDto;

public interface EmployeeService {

    EmployeeResponseDto getById(Long id);

    EmployeeResponseDto create(EmployeeCreateRequestDto dto);
}
