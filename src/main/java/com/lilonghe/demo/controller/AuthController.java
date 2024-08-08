package com.lilonghe.demo.controller;

import com.lilonghe.demo.model.User;
import com.lilonghe.demo.repository.UserRepository;
import com.lilonghe.demo.utils.APIResponse;
import com.lilonghe.demo.utils.MD5;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.NullType;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public APIResponse<NullType> login( @RequestBody User user, HttpServletResponse response) {
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return APIResponse.Error("输入信息不完整");
        }

        String password = MD5.encrypt(user.getPassword());
        Optional<User> findUser = userRepository.findByUsernameAndPassword(user.getUsername(), password);

        if (findUser.isEmpty()) {
            return APIResponse.Error("用户名或密码错误");
        }

        Cookie cookie = new Cookie("token", "balabala");
        cookie.setMaxAge(60 * 60 * 8);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return APIResponse.Success();
    }

    @DeleteMapping("/logout")
    public APIResponse<NullType> logout(HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("token", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return APIResponse.Success();
    }
}
