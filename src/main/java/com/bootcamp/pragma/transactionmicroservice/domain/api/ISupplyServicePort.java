package com.bootcamp.pragma.transactionmicroservice.domain.api;

import com.bootcamp.pragma.transactionmicroservice.domain.model.Supply;

public interface ISupplyServicePort {
    void saveSupply(Supply supply);
}
