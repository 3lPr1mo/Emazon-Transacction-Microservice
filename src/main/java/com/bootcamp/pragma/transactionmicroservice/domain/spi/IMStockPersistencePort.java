package com.bootcamp.pragma.transactionmicroservice.domain.spi;

import com.bootcamp.pragma.transactionmicroservice.application.dto.response.StockResponse;
import com.bootcamp.pragma.transactionmicroservice.domain.model.Supply;

public interface IMStockPersistencePort {
    StockResponse addStockToArticle(Supply supply);
}
