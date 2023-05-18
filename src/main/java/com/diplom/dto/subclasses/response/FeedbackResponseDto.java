package com.diplom.dto.subclasses.response;

import com.diplom.enums.Rating;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FeedbackResponseDto {

    private Long id;
    private String review;
    private Rating rating;
    private Long doctorId;
    private Long patientId;
}


