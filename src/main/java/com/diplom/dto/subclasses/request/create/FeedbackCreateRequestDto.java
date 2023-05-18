package com.diplom.dto.subclasses.request.create;

import com.diplom.dto.subclasses.FeedbackRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class FeedbackCreateRequestDto extends FeedbackRequestDto {

    @NotNull(message = "feedback.mandatory.doctorId")
    private Long doctorId;

    @NotNull(message = "feedback.mandatory.patientId")
    private Long patientId;
}
