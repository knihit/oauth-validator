package com.infaspects.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;

/**
 * Hello world!
 *
 */
//TODO - delete the class after completing the project
public class App 
{
    public static void main( String[] args )
    {
        Key key = MacProvider.generateKey();
        String compactJws = Jwts.builder()
                .setSubject("Joe")
                .signWith(SignatureAlgorithm.RS256, key)
                .compact();

        System.out.println( "Hello World!" );
        Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws).getBody().getSubject().equals("Joe");
    }
}
