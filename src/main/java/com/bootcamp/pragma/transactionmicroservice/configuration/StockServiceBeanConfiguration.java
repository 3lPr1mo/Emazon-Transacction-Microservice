package com.bootcamp.pragma.transactionmicroservice.configuration;

import com.bootcamp.pragma.transactionmicroservice.domain.spi.IMStockPersistencePort;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.adapter.MStockAdapter;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.feign.IStockServiceFeign;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.mapper.IStockArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class StockServiceBeanConfiguration {

    private final IStockServiceFeign stockServiceFeign;
    private final IStockArticleMapper stockArticleMapper;

    @Bean
    public IMStockPersistencePort stockPersistencePort() {
        return new MStockAdapter(stockServiceFeign, stockArticleMapper);
    }

}
