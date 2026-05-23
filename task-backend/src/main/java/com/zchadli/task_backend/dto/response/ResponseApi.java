package com.zchadli.task_backend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ResponseApi<T> {
    private int status;
    private String message;
    private T data;
    private List<String> errors;
    private LocalDateTime timestamp;
}
