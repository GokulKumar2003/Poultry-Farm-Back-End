package com.PF.PoultryFarm.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "abcdefghijklmnopqrstuvwxyz";
    private final long EXPIRATION_TIME = 86400000L;
    private final Key key;

    public JwtUtil() {
        byte[] keyBytes = Base64.getEncoder().encode("abcdefghijklmnopqrstuvwxyz".getBytes());
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 86400000L)).signWith(this.key, SignatureAlgorithm.HS256).compact();
    }

    public String extractUsername(String token) {
        System.out.println(token);
        return ((Claims)Jwts.parserBuilder().setSigningKey(this.key).build().parseClaimsJws(token).getBody()).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(this.key).build().parseClaimsJws(token);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }
}
