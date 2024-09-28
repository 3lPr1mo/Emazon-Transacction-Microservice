package com.bootcamp.pragma.transactionmicroservice.configuration.security;

import org.springframework.beans.factory.annotation.Value;

public class SecretConstant {
    private SecretConstant() {}

    @Value("${jwtsecret}")
    public static String jwtSecret;
}
