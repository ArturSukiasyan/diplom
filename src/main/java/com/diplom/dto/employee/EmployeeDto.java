package com.diplom.dto.employee;

import com.diplom.annotation.PhoneNumber;
import com.diplom.enums.Availability;
import com.diplom.enums.Level;
import com.diplom.enums.Presence;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public abstract class EmployeeDto {

    @Nullable
    @PhoneNumber
    private String phoneNumber;

    @Nullable
    private Boolean hiddenNumber = false;

    @NotNull(message = "{employee.mandatory.level}")
    private Level level;

    @NotNull(message = "{employee.mandatory.availability}")
    private Availability availability;

    @NotNull(message = "{employee.mandatory.presence}")
    private Presence presence;

    @NotBlank(message = "{mandatory.title}")
    @Size(max = 50, message = "{invalid.title}")
    private String title;

    @Nullable
    @Size(max = 250, message = "{invalid.description}")
    private String description;

    @Nullable
    private String profilePhotoName;

    @Nullable
    private String cvName;

    @NotEmpty(message = "{employee.mandatory.skills}")
    private List<String> skills = new ArrayList<>();
}
