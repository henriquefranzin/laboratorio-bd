package com.projeto.service;

import com.auth0.jwt.JWT;
import com.projeto.model.User;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;

import static com.auth0.jwt.algorithms.Algorithm.HMAC256;
import static java.time.LocalDateTime.now;

@Service
public class TokenService {

    public String generateToken(User user){
        return JWT.create()
                .withSubject(user.getLogin())
                .withClaim("id", user.getUserid())
                .withExpiresAt(now()
                        .plusHours(24)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(HMAC256("9acfa7aa-f07a-4c5a-a29a-11aabdbb2d64"));
    }

    public String getSubject(String token) {
        return JWT.require(HMAC256("9acfa7aa-f07a-4c5a-a29a-11aabdbb2d64"))
                .build().verify(token).getSubject();

    }
}
