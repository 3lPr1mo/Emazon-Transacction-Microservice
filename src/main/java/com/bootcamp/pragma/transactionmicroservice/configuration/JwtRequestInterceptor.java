package com.bootcamp.pragma.transactionmicroservice.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class JwtRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null || authentication.isAuthenticated()) {
            String token = (String) authentication.getCredentials();
            requestTemplate.header(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        }
    }

}
