package com.jobick.dto.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private String message;
    private Date timestamp;
    private Integer status;
    private String error;
    private String path;

}
