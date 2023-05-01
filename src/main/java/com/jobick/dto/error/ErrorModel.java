package com.jobick.dto.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorModel {

    private String listName;
    private String listIndex;
    private String fieldName;
    private Object rejectedValue;
    private String messageError;
}
