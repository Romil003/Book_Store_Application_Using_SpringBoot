package com.bridgelabz.bookstoreapplication.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JwtToken {

    private static final String SECRET = "Romil";

    public String encodeToken(int Id){
        String token = null;
        token= JWT.create().withClaim("id",Id).sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    public Integer decodeToken(String jwt) {
        int id = 0;
        if(jwt != null){
            id=JWT.require(Algorithm.HMAC256(SECRET)).build().verify(jwt).getClaim("id").asInt();
        }
        return id;
    }
}
