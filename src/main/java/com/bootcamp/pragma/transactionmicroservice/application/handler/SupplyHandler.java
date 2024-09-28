package com.bootcamp.pragma.transactionmicroservice.application.handler;

import com.bootcamp.pragma.transactionmicroservice.application.dto.request.AddStockArticleRequest;
import com.bootcamp.pragma.transactionmicroservice.application.mapper.ISupplyMapper;
import com.bootcamp.pragma.transactionmicroservice.domain.api.ISupplyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplyHandler {

    private final ISupplyMapper supplyMapper;
    private final ISupplyServicePort supplyServicePort;

    public void saveSupply(AddStockArticleRequest stockArticle){
        supplyServicePort.saveSupply(supplyMapper.toSupplyFromAddStockArticleRequest(stockArticle));
    }

}
