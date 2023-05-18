package com.diplom.service.doctor;

import com.diplom.dto.subclasses.request.create.FeedbackCreateRequestDto;
import com.diplom.dto.subclasses.request.update.FeedbackUpdateRequestDto;
import com.diplom.dto.subclasses.response.FeedbackResponseDto;

import java.util.List;

public interface FeedbackService {

    FeedbackResponseDto create(FeedbackCreateRequestDto dto);

    List<FeedbackResponseDto> getDoctorFeedbacks(Long doctorId);

    FeedbackResponseDto edit(FeedbackUpdateRequestDto dto);

    void delete(Long id);
}
