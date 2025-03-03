package com.jd.utils;

import com.jd.entity.Customer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    public static String createJWTTokenFromCustomer(Customer customer) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("customerEmail", customer.getCustomerEmail());
        claims.put("customerId",customer.getCustomerId());
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "smile_shark_JD")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .compact();
    }

    public static Claims parseJWTTokenToCustomer(String token) {
        return Jwts.parser()
                .setSigningKey("smile_shark_JD")
                .parseClaimsJws(token)
                .getBody();
    }
}