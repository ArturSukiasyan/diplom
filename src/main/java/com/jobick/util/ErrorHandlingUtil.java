package com.jobick.util;

import com.jobick.dto.error.ApiError;
import com.jobick.dto.error.ErrorModel;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@UtilityClass
@Slf4j
public class ErrorHandlingUtil {

    public static ErrorModel getErrorModel(FieldError err) {
        String errField = err.getField();
        String listName = null;
        String listIndex = null;

        if (errField.contains("[")) {
            String[] listField = errField.split("\\.");
            int splitIndex = errField.indexOf("[");
            listName = listField[0].substring(0, splitIndex);
            errField = listField[1];
            listIndex = listField[0].substring(splitIndex + 1, listField[0].length() - 1);
        }
        return ErrorModel.builder()
                .fieldName(errField)
                .rejectedValue(err.getRejectedValue())
                .messageError(err.getDefaultMessage())
                .listIndex(listIndex)
                .listName(listName)
                .build();
    }

    public static ApiError errorDetails(String message, Exception exception, HttpStatus httpStatus, HttpServletRequest request) {
        var errorDetail = ApiError.builder()
                .message(message)
                .status(httpStatus.value())
                .timestamp(new Date())
                .error(httpStatus.getReasonPhrase())
                .path(request.getRequestURI().substring(request.getContextPath().length())).build();

        log.error(exception.getMessage());
        return errorDetail;
    }
}
