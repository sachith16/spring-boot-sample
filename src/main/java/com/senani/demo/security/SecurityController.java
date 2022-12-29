package com.senani.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/security")
public class SecurityController {

    String secret = "09b0c7e38b75546e0190addf0bdfc745";

    @RequestMapping("/tokens")
    public Map<String, String> generateToken() {
        Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
        String accessToken = JWT.create()
                .withSubject("username1")
                .withExpiresAt(new Date(new Date().getTime() + TimeUnit.DAYS.toMillis(365)))
                .withIssuer("https://example.io")
                .withIssuedAt(new Date())
                .withClaim("role", "ADMIN")
                .sign(algorithm);

        checkGeneratedToken(accessToken);
        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", accessToken);
        return tokens;
    }

    private void checkGeneratedToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        String username = decodedJWT.getSubject();
        System.out.println("decodedJWT subject : " + username);
    }

}
