package com.diplom.dto.employee.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class EmployeeCreateRequestDto extends EmployeeRequestDto {

    @NotBlank(message = "{mandatory.firstName}")
    private String firstName;

    @NotBlank(message = "{mandatory.lastName}")
    private String lastName;

    @Email(message = "{invalid.email}")
    @NotBlank(message = "{mandatory.email}")
    private String email;

}
