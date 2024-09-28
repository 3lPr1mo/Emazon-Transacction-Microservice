package com.bootcamp.pragma.transactionmicroservice.configuration;

import com.bootcamp.pragma.transactionmicroservice.domain.api.ISupplyServicePort;
import com.bootcamp.pragma.transactionmicroservice.domain.api.usecase.SupplyUseCase;
import com.bootcamp.pragma.transactionmicroservice.domain.spi.ISupplyPersistencePort;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.adapter.SupplyAdapter;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SupplyBeanConfiguration {

    private final ISupplyRepository supplyRepository;
    private final ISupplyEntityMapper supplyEntityMapper;
    private final StockServiceBeanConfiguration stockConfig;

    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {
        return new SupplyAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    public ISupplyServicePort supplyServicePort() {
        return new SupplyUseCase(supplyPersistencePort(), stockConfig.stockPersistencePort());
    }

}
