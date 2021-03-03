package com.woniu.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

public class JWTUtil {
    //工具类的 用途，将创建jwt和解析jwt的代码抽取，实现代码的复用
    private static final Long EXPIRE_TIME=6*60*24L;//设置过期时间
    private static final String SING= SaltUtils.getSalt(22);
    //创建jwt
    public static String createToken(HashMap<String,String> map){
        JWTCreator.Builder builder = JWT.create();

        map.forEach((k,v)->{
          builder.withClaim(k,v);
        });
        JWTCreator.Builder builder1 = builder.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME));
        String token = builder.sign(Algorithm.HMAC256(SING));
        return token;
    }
    //解析jwt
    public static DecodedJWT decodedJWT(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
        return verify;
    }
}
