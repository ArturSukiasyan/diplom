package com.diplom.advice;

import com.diplom.dto.error.ApiError;
import com.diplom.dto.error.ErrorModel;
import com.diplom.dto.error.ErrorResponse;
import com.diplom.exception.DoctorNotFoundException;
import com.diplom.exception.PatientNotFoundException;
import com.diplom.util.ErrorHandlingUtil;
import io.minio.errors.MinioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import static com.diplom.util.ErrorHandlingUtil.errorDetails;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = DoctorNotFoundException.class)
    public ResponseEntity<Object> exception(DoctorNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = PatientNotFoundException.class)
    public ResponseEntity<Object> exception(PatientNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception) {

        List<ErrorModel> errorMessages = exception.getBindingResult().getFieldErrors().stream()
                .map(ErrorHandlingUtil::getErrorModel)
                .distinct()
                .collect(Collectors.toList());
        ErrorResponse response = ErrorResponse.builder().errorMessage(errorMessages).build();
        return ResponseEntity.badRequest().body(response);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler({MinioException.class, InvocationTargetException.class})
    public ResponseEntity<ApiError> handleMinioException(Exception ex, HttpServletRequest request) {
        ApiError response = errorDetails("File Not Found !", ex, NOT_FOUND, request);
        return ResponseEntity
                .status(NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({IllegalStateException.class, IOException.class})
    public ResponseEntity<ApiError> handleException(Exception ex, HttpServletRequest request) {
        ApiError response = errorDetails(ex.getMessage(), ex, INTERNAL_SERVER_ERROR, request);
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
