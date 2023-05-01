package com.diplom.dto.minio;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL, valueFilter = RepresentationModel.class)
public class FileResponse extends RepresentationModel<FileResponse> implements Serializable {
    private String filename;
    private String contentType;
    private Long fileSize;
    private Date createdTime;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private transient InputStreamResource stream;
}
