package com.lilonghe.demo.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lilonghe.demo.utils.APIResponse;
import com.lilonghe.demo.utils.JWTToken;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Value("${jwt.key}")
    private String JWTKey;

    @Value("${cookie.name}")
    private String CookieName;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("/auth/login".equals(request.getRequestURI())) {
            return true;
        }
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("token".equals(cookie.getName())) {
                    String username = JWTToken.parse(JWTKey, cookie.getValue());
                    if (!username.isEmpty()) {
                        return true;
                    }
                }
            }
        }

        String headerAuthorization = request.getHeader("Authorization");
        if (headerAuthorization != null && headerAuthorization.startsWith("Bearer ")){
            String token = headerAuthorization.substring(7);
            String username = JWTToken.parse(JWTKey, token);
            if (!username.isEmpty()) {
                return true;
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
