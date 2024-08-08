package com.lilonghe.demo.utils;

import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

public class JWTToken {
    public static String generate(String data, String key) {
        Key securityKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");

        return Jwts.builder().
                subject(data).
                expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 8)).
                signWith(securityKey).
                compact();
    }

    public static String parse(String key, String token) {
        SecretKey securityKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");

        return Jwts.parser().verifyWith(securityKey).build().parseSignedClaims(token).getPayload().getSubject();
    }
}
