package com.chenbro.deliverybarcode;

import static org.junit.Assert.assertTrue;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testToken(){
        JwtBuilder jwtBuilder = Jwts.builder().setId("88").setSubject("kervin").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "rookie");
        String compact = jwtBuilder.compact();
        System.out.println(compact);
    }
}
