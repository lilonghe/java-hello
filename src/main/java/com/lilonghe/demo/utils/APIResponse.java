package com.lilonghe.demo.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.lang.model.type.NullType;

@Data
@AllArgsConstructor
@JsonSerialize
public class APIResponse<T> {
    private int code;
    private String message;
    private T data;

    public static <T> APIResponse<T> Success() {
        return new APIResponse<>(200, "success", null);
    }

    public static <T> APIResponse<T> Success(T data) {
        return new APIResponse<>(200, "success", data);
    }

    public static <T> APIResponse<T> Success(T data, String message) {
        return new APIResponse<>(200, message, data);
    }

    public static <T> APIResponse<T> Error(String message) {
        return new APIResponse<>(400, message, null);
    }
}
