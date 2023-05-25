package com.diplom.service.impl;

import com.diplom.dto.subclasses.request.create.FeedbackCreateRequestDto;
import com.diplom.dto.subclasses.request.update.FeedbackUpdateRequestDto;
import com.diplom.dto.subclasses.response.FeedbackResponseDto;
import com.diplom.entity.Feedback;
import com.diplom.exception.FeedbackNotFoundException;
import com.diplom.mapper.FeedbackMapper;
import com.diplom.repository.FeedbackRepository;
import com.diplom.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackMapper mapper;

    @Override
    public FeedbackResponseDto create(FeedbackCreateRequestDto dto) {
        log.info("Start saving Feedback by this data : {}", dto.toString());
        Feedback feedback = feedbackRepository.save(mapper.dtoToEntity(dto));

        log.info("Feedback successfully created by id : {}", feedback.getId());

        return mapper.entityToDto(feedback);
    }

    @Override
    public List<FeedbackResponseDto> getDoctorFeedbacks(Long doctorId) {
        log.info("Get all doctor's feedbacks by doctor id : " + doctorId);
        return mapper.entityListToDtoList(feedbackRepository.findAllByDoctorId(doctorId));
    }

    @Override
    public FeedbackResponseDto edit(FeedbackUpdateRequestDto dto) {
        log.info("Edit feedback :" + dto.toString());
        Feedback feedback = feedbackRepository.findById(dto.getId())
            .orElseThrow(() -> new FeedbackNotFoundException(dto.getId()));
        feedback.setReview(dto.getReview());
        feedback.setRating(dto.getRating());
        feedback = feedbackRepository.save(feedback);
        return mapper.entityToDto(feedback);

    }

    @Override
    public void delete(Long id) {
        log.info("Start deleting feedback by id : {}", id);
        try {
            feedbackRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new FeedbackNotFoundException(id);
        }
    }


}
