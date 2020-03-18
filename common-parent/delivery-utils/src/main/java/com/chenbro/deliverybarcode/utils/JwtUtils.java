package com.chenbro.deliverybarcode.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @ClassName JwtUtils
 * @Description TODO   token工具类
 * @Author c8777
 * @Date 2020/3/3 17:37
 * @Version 1.0
 **/
@Component
public class JwtUtils {

    //签名私钥
    private String key = "dataHub";

    //签名的失效时间
    private Long ttl = 3600000L;             //1小时

    /**
    * @Description //TODO  设置认证token   id:登录用户id  subject:登录用户名
    * @Date 2020/3/3 17:45
    * @return 
    **/
    public String createJwt(String id, String name, Map<String,Object> map){
        //1.设置失效时间
        long now = System.currentTimeMillis();
        long exp = now + ttl;

        //2.创建jwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder().setId(id)
                .setSubject(name)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key);
        //3.根据map设置claims
        for(Map.Entry<String,Object> entry : map.entrySet()){
            jwtBuilder.claim(entry.getKey(),entry.getValue());
        }
        //4.创建token
        String token = jwtBuilder.compact();
        return token;
    }

    /**
    * @Description //TODO 解析token字符串获取claims
    * @Date 2020/3/3 18:12
    * @return io.jsonwebtoken.Claims
    **/
    public Claims parseJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }
}
