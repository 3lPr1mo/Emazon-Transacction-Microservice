package com.bootcamp.pragma.transactionmicroservice.domain.spi;

import com.bootcamp.pragma.transactionmicroservice.domain.model.Supply;

public interface ISupplyPersistencePort {
    void saveSupply(Supply supply);
}
