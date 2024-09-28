package com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.adapter;

import com.bootcamp.pragma.transactionmicroservice.application.dto.response.StockResponse;
import com.bootcamp.pragma.transactionmicroservice.domain.model.Supply;
import com.bootcamp.pragma.transactionmicroservice.domain.spi.IMStockPersistencePort;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.feign.IStockServiceFeign;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.mapper.IStockArticleMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MStockAdapter implements IMStockPersistencePort {

    private final IStockServiceFeign stockServiceFeign;
    private final IStockArticleMapper stockArticleMapper;

    @Override
    public StockResponse addStockToArticle(Supply supply) {
        return stockServiceFeign.updateStock(stockArticleMapper.toDtoFromSupply(supply)).getBody();
    }
}
