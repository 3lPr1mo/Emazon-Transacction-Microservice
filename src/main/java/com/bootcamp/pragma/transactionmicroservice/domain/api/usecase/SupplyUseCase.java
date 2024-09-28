package com.bootcamp.pragma.transactionmicroservice.domain.api.usecase;

import com.bootcamp.pragma.transactionmicroservice.domain.api.ISupplyServicePort;
import com.bootcamp.pragma.transactionmicroservice.domain.constants.MicroserviceConstants;
import com.bootcamp.pragma.transactionmicroservice.domain.exception.StockMicroserviceException;
import com.bootcamp.pragma.transactionmicroservice.domain.model.Supply;
import com.bootcamp.pragma.transactionmicroservice.domain.spi.IMStockPersistencePort;
import com.bootcamp.pragma.transactionmicroservice.domain.spi.ISupplyPersistencePort;

import java.time.LocalDateTime;

public class SupplyUseCase implements ISupplyServicePort {

    private final ISupplyPersistencePort supplyPersistencePort;
    private final IMStockPersistencePort stockPersistencePort;

    public SupplyUseCase(ISupplyPersistencePort supplyPersistencePort, IMStockPersistencePort stockPersistencePort) {
        this.supplyPersistencePort = supplyPersistencePort;
        this.stockPersistencePort = stockPersistencePort;
    }

    @Override
    public void saveSupply(Supply supply) {

        // Calling persistence port first to Feign
        if(!stockPersistencePort.addStockToArticle(supply).getStatus()){
            throw new StockMicroserviceException(MicroserviceConstants.SAVE_SUPPLIES_ERROR_MSG);
        }

        supply.setDate(LocalDateTime.now());
        supply.setRestockDate(LocalDateTime.now().plusMonths(1));
        supplyPersistencePort.saveSupply(supply);
    }

}
