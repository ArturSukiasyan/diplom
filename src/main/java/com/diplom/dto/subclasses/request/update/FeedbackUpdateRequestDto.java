package com.diplom.dto.subclasses.request.update;

import com.diplom.dto.subclasses.FeedbackRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class FeedbackUpdateRequestDto extends FeedbackRequestDto {

    @NotBlank(message = "mandatory.id")
    private Long id;

}
