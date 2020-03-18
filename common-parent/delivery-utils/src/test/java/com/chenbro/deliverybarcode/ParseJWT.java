package com.chenbro.deliverybarcode;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.Test;

/**
 * @ClassName ParseJWT
 * @Description TODO
 * @Author c8777
 * @Date 2020/3/3 17:27
 * @Version 1.0
 **/
public class ParseJWT {

    @Test
    public void parseJwt(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4OCIsInN1YiI6ImtlcnZpbiIsImlhdCI6MTU4MzIyODEzOSwiY29tcGFueUlkIjoiMTI0NTYifQ.iiT1XVVaBQUUmlWGUgGwU-FmJeK1Bes2Du2yfEzlgfc";
        Claims claims = Jwts.parser().setSigningKey("rookie").parseClaimsJws(token).getBody();
        //私有数据存放在claims
        System.out.println(claims.getId());
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.getSubject());
        System.out.println(claims.get("companyId"));
    }
}
