package com.lilonghe.demo.exception;

import com.lilonghe.demo.utils.APIResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public APIResponse<String> globalExceptionHandler(Exception ex) {
        return new APIResponse<>(500, ex.getMessage(), null);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseBody
    public APIResponse<String> notFoundExceptionHandler(Exception ex) {
        return new APIResponse<>(404, "未找到相关资源", null);
    }
}
