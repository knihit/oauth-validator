package com.infaspects.security.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Validate JWT Token
 */
@Component
public class TokenValidator {

    private static String REQ_HEADER_AUTHORIZATION = "Authorization";

    private static String TOKEN_PREFIX = "Bearer ";

    /**
     * Method to extract token from the request header
     *
     * @param request - extract JWT from request header
     * @return - token string stripping the Bearer prefix
     */
    private String getToken(HttpServletRequest request) {
        /**
         *  Getting the token from Authentication header
         *  e.g Bearer your_token
         */
        String authHeader = request.getHeader(REQ_HEADER_AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith(TOKEN_PREFIX)) {
            return authHeader.substring(7);
        }

        return null;
    }


    /**
     * Method to validate the OAuth token
     *
     * @param request - parameter required to extract the bearer token from the HTTP request header
     * @return - returns true if able to validate the OAuth token
     */
    public Boolean validateToken(HttpServletRequest request) {
        Boolean isAuthorised = false;

        /*
        if (Jwts.parser().setSigningKey(MacProvider.generateKey(SignatureAlgorithm.RS256)).parseClaimsJws(getToken(request)).getBody().getSubject().equals("Joe"))
            isAuthorised = true;*/

        //TODO - retrieve key
        //TODO - cache key for 720 mins
        //TODO - validate token with key

        return isAuthorised;
    }
}
