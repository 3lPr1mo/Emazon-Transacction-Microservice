package com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.adapter;

import com.bootcamp.pragma.transactionmicroservice.application.dto.request.GetUserRequest;
import com.bootcamp.pragma.transactionmicroservice.application.dto.response.UserResponse;
import com.bootcamp.pragma.transactionmicroservice.domain.spi.IMUserPersistencePort;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.feign.IUserServiceFeign;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MUserAdapter implements IMUserPersistencePort {

    private final IUserServiceFeign userFeign;
    private final JwtAdapter jwtService;

    @Override
    public Long getUserId() {
        String email = jwtService.getEmailFromToken();
        UserResponse response =  userFeign.getUserIdByEmail(new GetUserRequest(email)).getBody();
        return response.getId();
    }
}
