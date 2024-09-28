package com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.feign;

import com.bootcamp.pragma.transactionmicroservice.application.dto.request.GetUserRequest;
import com.bootcamp.pragma.transactionmicroservice.application.dto.response.UserResponse;
import com.bootcamp.pragma.transactionmicroservice.configuration.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "usermicroservice",
             url = "${external.user.microservice.api}",
             configuration = FeignClientConfig.class)
public interface IUserServiceFeign {
    @GetMapping("/user/")
    ResponseEntity<UserResponse> getUserIdByEmail(@RequestBody GetUserRequest getUserRequest);
}
