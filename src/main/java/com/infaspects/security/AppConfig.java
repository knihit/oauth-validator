package com.infaspects.security;

import com.infaspects.security.util.TokenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public TokenValidator getTokenValidator() {
        return new TokenValidator();
    }
}
