package com.diplom.dto.subclasses;

import com.diplom.enums.Rating;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public abstract class FeedbackRequestDto {

    @NotBlank(message = "feedback.invalid.review")
    @Size(max = 255, message = "feedback.mandatory.review")
    private String review;

    @NotNull(message = "feedback.mandatory.rating")
    private Rating rating;

}
