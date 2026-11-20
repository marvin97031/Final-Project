package com.project.back_end.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    // Klucz tajny (w prawdziwej aplikacji powinien być w application.properties)
    private static final String SECRET = "mySuperSecretKeyForSmartClinicManagementSystem12345";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // Metoda generująca token JWT na podstawie e-maila
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 godziny
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Metoda zwracająca klucz podpisu
    public Key getSigningKey() {
        return key;
    }

    // Prosta metoda walidacji (do użytku w kontrolerach)
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}