package com.bootcamp.pragma.transactionmicroservice.configuration.security;

import com.bootcamp.pragma.transactionmicroservice.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigFilter {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public RequestMatcher whitelistRequestMatcher() {
        List<String> whitelist = List.of(
                "/api-doc/**",
                "/api-doc/swagger-config",
                "/swagger-ui/**",
                "/auth/register/admin",
                "/auth/login"
        );

        return request -> whitelist.stream().anyMatch(request.getServletPath()::equals);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(whitelistRequestMatcher()).permitAll()
                        .requestMatchers("transaction/stock").hasAnyAuthority(Role.AUX_BODEGA.name())
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
