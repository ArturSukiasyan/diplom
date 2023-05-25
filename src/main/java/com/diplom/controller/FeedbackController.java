package com.diplom.controller;

import com.diplom.dto.subclasses.request.create.FeedbackCreateRequestDto;
import com.diplom.dto.subclasses.request.update.FeedbackUpdateRequestDto;
import com.diplom.dto.subclasses.response.FeedbackResponseDto;
import com.diplom.service.FeedbackService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@Tag(name = "Feedback")
@RequiredArgsConstructor
@RequestMapping(value = "/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeedbackResponseDto> createFeedback(@RequestBody @Valid FeedbackCreateRequestDto dto) {
        FeedbackResponseDto feedback = feedbackService.create(dto);
        return ResponseEntity.ok().body(feedback);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeedbackResponseDto> editFeedback(@RequestBody @Valid FeedbackUpdateRequestDto dto) {
        FeedbackResponseDto feedback = feedbackService.edit(dto);
        return ResponseEntity.ok().body(feedback);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFeedback(final @PathVariable("id") Long id) {
        feedbackService.delete(id);
        return ResponseEntity.status(200).build();
    }
}
