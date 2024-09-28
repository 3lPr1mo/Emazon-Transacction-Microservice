package com.bootcamp.pragma.transactionmicroservice.configuration;

import com.bootcamp.pragma.transactionmicroservice.domain.spi.IMUserPersistencePort;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.adapter.JwtAdapter;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.adapter.MUserAdapter;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.feign.IUserServiceFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserServiceBeanConfiguration {

    private final IUserServiceFeign userServiceFeign;
    private final JwtAdapter jwtAdapter;

    @Bean
    public IMUserPersistencePort userPersistencePort() {
        return new MUserAdapter(userServiceFeign, jwtAdapter);
    }

}
