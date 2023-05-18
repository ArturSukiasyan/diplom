package com.diplom.mapper;

import com.diplom.dto.subclasses.request.create.FeedbackCreateRequestDto;
import com.diplom.dto.subclasses.request.update.FeedbackUpdateRequestDto;
import com.diplom.dto.subclasses.response.FeedbackResponseDto;
import com.diplom.entity.Feedback;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.WARN,
    injectionStrategy = InjectionStrategy.FIELD,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface FeedbackMapper {

    FeedbackResponseDto entityToDto(Feedback feedback);

    List<FeedbackResponseDto> entityListToDtoList(List<Feedback> feedbackList);

    Feedback dtoToEntity(FeedbackCreateRequestDto dto);

    Feedback dtoToEntity(FeedbackUpdateRequestDto dto);
}
