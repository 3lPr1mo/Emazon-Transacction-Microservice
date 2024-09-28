package com.bootcamp.pragma.transactionmicroservice;

import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.feign.IStockServiceFeign;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.feign.IUserServiceFeign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {IStockServiceFeign.class, IUserServiceFeign.class})
public class TransactionMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionMicroserviceApplication.class, args);
    }

}
