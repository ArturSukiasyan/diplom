package com.diplom.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DoctorController {

//    private final EmployeeService employeeService;
//
//    @PostMapping(
//        value = "/employee",
//        consumes = MediaType.APPLICATION_JSON_VALUE,
//        produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody @Valid EmployeeCreateRequestDto dto) {
//        EmployeeResponseDto employeeResponseDto = employeeService.create(dto);
//        return ResponseEntity.ok().body(employeeResponseDto);
//    }
//
//    @GetMapping(value = "/employee/{id}")
//    public ResponseEntity<EmployeeResponseDto> getEmployee(final @PathVariable("id") Long id) {
//        EmployeeResponseDto employeeResponseDto = employeeService.getById(id);
//        return ResponseEntity.ok(employeeResponseDto);
//    }


}
