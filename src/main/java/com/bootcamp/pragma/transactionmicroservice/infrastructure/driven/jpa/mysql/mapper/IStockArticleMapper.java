package com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.mapper;

import com.bootcamp.pragma.transactionmicroservice.domain.model.StockArticle;
import com.bootcamp.pragma.transactionmicroservice.domain.model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IStockArticleMapper {
    StockArticle toDtoFromSupply(Supply supply);
}
