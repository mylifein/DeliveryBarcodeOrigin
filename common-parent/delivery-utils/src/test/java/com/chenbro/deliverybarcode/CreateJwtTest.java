package com.chenbro.deliverybarcode;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;

/**
 * @ClassName CreateJwtTest
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/3 17:26
 * @Version 1.0
 **/
public class CreateJwtTest {


    @Test
    public void testToken(){
        JwtBuilder jwtBuilder = Jwts.builder().setId("88")
                .setSubject("kervin")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "rookie")
                .claim("companyId","12456");
        String compact = jwtBuilder.compact();
        System.out.println(compact);
    }
}
