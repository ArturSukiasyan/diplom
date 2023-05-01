package com.diplom.controller;

import com.diplom.dto.employee.request.EmployeeCreateRequestDto;
import com.diplom.dto.employee.response.EmployeeResponseDto;
import com.diplom.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(value = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody @Valid EmployeeCreateRequestDto dto) {
        EmployeeResponseDto employeeResponseDto = employeeService.create(dto);
        return ResponseEntity.ok().body(employeeResponseDto);
    }

    @GetMapping(value ="/employee/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployee(final @PathVariable("id") Long id) {
        EmployeeResponseDto employeeResponseDto = employeeService.getById(id);
        return ResponseEntity.ok(employeeResponseDto);
    }


}
