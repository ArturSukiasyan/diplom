package com.diplom.service.employee.impl;

import com.diplom.dto.employee.request.EmployeeCreateRequestDto;
import com.diplom.dto.employee.response.EmployeeResponseDto;
import com.diplom.entity.employee.Employee;
import com.diplom.exception.EmployeeNotFoundException;
import com.diplom.mapper.employee.EmployeeMapper;
import com.diplom.repository.EmployeeRepository;
import com.diplom.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponseDto getById(Long id) {
        log.info("Getting employee by id : {}", id);
        var employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            log.error("Failed to get employee.");
            throw new EmployeeNotFoundException(id);
        } else {
            log.info("Employee was been getting successfully");
            return employeeMapper.entityToDto(employee.get());
        }
    }

    @Override
    public EmployeeResponseDto create(EmployeeCreateRequestDto dto) {
        log.info("Start saving employee by this data : {}", dto.toString());
        Employee employee = employeeRepository.save(employeeMapper.dtoToEntity(dto));

        log.info("Employee successfully created by id : {}", employee.getId());

        return employeeMapper.entityToDto(employee);

    }
}
