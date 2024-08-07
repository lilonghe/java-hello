package com.lilonghe.demo.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lilonghe.demo.utils.APIResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("/auth/login".equals(request.getRequestURI())) {
            return true;
        }
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("token".equals(cookie.getName())) {
                    return true;
                }
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        APIResponse<Object> resp = new APIResponse<>(401, "未登录", null);
        String json = mapper.writeValueAsString(resp);

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json);
        return false;
    }
}
