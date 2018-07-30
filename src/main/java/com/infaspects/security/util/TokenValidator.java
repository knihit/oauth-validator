package com.infaspects.security.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.servlet.http.HttpServletRequest;

public class TokenValidator {

    private static String REQ_HEADER_AUTHORIZATION = "Authorization";

    private String getToken( HttpServletRequest request ) {
        /**
         *  Getting the token from Authentication header
         *  e.g Bearer your_token
         */
        String authHeader = request.getHeader(REQ_HEADER_AUTHORIZATION);
        if ( authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }


    /**
     * Method to validate the OAuth token
     * @param request - parameter required to extract the bearer token from the HTTP request header
     * @return - returns true if able to validate the OAuth token
     */
    public Boolean validateToken(HttpServletRequest request) {
        Boolean isAuthorised = false;

        if (Jwts.parser().setSigningKey(MacProvider.generateKey(SignatureAlgorithm.RS256)).parseClaimsJws(getToken(request)).getBody().getSubject().equals("Joe"))
            isAuthorised = true;
        return isAuthorised;
    }
}
