package com.lilonghe.demo.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lilonghe.demo.interceptor.AuthInterceptor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@JsonSerialize
public class APIResponse<T> {
    private int code;
    private String message;
    private T data;
}
