package com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.feign;

import com.bootcamp.pragma.transactionmicroservice.application.dto.response.StockResponse;
import com.bootcamp.pragma.transactionmicroservice.configuration.FeignClientConfig;
import com.bootcamp.pragma.transactionmicroservice.domain.model.StockArticle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-microservice",
        url = "${external.stock.microservice.api}",
        configuration = FeignClientConfig.class)
public interface IStockServiceFeign {

    @PutMapping("/article")
    ResponseEntity<StockResponse> updateStock(@RequestBody StockArticle request);

}
