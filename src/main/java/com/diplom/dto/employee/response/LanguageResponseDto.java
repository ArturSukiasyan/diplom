package com.diplom.dto.employee.response;

import com.diplom.dto.employee.LanguageDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class LanguageResponseDto extends LanguageDto {

    @NotNull
    private Long id;


}
