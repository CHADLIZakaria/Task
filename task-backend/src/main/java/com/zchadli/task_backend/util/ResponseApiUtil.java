package com.zchadli.task_backend.util;

import com.zchadli.task_backend.dto.response.ResponseApi;

import java.time.LocalDateTime;

public class ResponseApiUtil {
    public static <T> ResponseApi<T> success(int status, String message, T data) {
        return ResponseApi.<T>builder()
                .data(data)
                .status(status)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
    public static ResponseApi error(int status, String message) {
        return ResponseApi.builder()
                .message(message)
                .status(status)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
