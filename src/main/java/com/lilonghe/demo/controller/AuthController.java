package com.lilonghe.demo.controller;

import com.lilonghe.demo.utils.APIResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public APIResponse<Boolean> login(HttpServletResponse response) {
        Cookie cookie = new Cookie("token", "balabala");
        cookie.setMaxAge(60 * 60 * 8);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return new APIResponse<>(200, "success", true);
    }

    @GetMapping("/logout")
    public APIResponse<Boolean> logout(HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("token", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return new APIResponse<>(200, "success", true);
    }
}
