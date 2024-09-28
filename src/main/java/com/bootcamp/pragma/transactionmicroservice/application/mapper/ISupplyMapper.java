package com.bootcamp.pragma.transactionmicroservice.application.mapper;

import com.bootcamp.pragma.transactionmicroservice.application.dto.request.AddStockArticleRequest;
import com.bootcamp.pragma.transactionmicroservice.domain.model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISupplyMapper {

    Supply toSupplyFromAddStockArticleRequest(AddStockArticleRequest addStockArticleRequest);

}
