package com.jobick.advice;

import com.jobick.dto.error.ApiError;
import com.jobick.dto.error.ErrorModel;
import com.jobick.dto.error.ErrorResponse;
import com.jobick.exception.EmployeeNotFoundException;
import com.jobick.util.ErrorHandlingUtil;
import io.minio.errors.MinioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import static com.jobick.util.ErrorHandlingUtil.errorDetails;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<Object> exception(EmployeeNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception) {

        List<ErrorModel> errorMessages = exception.getBindingResult().getFieldErrors().stream()
                .map(ErrorHandlingUtil::getErrorModel)
                .distinct()
                .collect(Collectors.toList());
        ErrorResponse response = ErrorResponse.builder().errorMessage(errorMessages).build();
        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler({MinioException.class, InvocationTargetException.class})
    ResponseEntity<ApiError> handleMinioException(Exception ex, HttpServletRequest request) {
        ApiError response = errorDetails("File Not Found !", ex, NOT_FOUND, request);
        return ResponseEntity
                .status(NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @ExceptionHandler({IllegalStateException.class, IOException.class})
    ResponseEntity<ApiError> handleException(Exception ex, HttpServletRequest request) {
        ApiError response = errorDetails(ex.getMessage(), ex, INTERNAL_SERVER_ERROR, request);
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
