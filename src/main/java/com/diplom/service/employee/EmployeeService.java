package com.diplom.service.employee;

import com.diplom.dto.employee.request.EmployeeCreateRequestDto;
import com.diplom.dto.employee.response.EmployeeResponseDto;

public interface EmployeeService {

    EmployeeResponseDto getById(Long id);

    EmployeeResponseDto create(EmployeeCreateRequestDto dto);
}
