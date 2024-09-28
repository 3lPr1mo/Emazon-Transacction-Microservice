package com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.adapter;

import com.bootcamp.pragma.transactionmicroservice.domain.model.Supply;
import com.bootcamp.pragma.transactionmicroservice.domain.spi.ISupplyPersistencePort;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.mapper.ISupplyEntityMapper;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.repository.ISupplyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyAdapter implements ISupplyPersistencePort {

    private final ISupplyRepository supplyRepository;
    private final ISupplyEntityMapper supplyEntityMapper;

    @Override
    public void saveSupply(Supply supply) {
        supplyRepository.save(supplyEntityMapper.toEntityFromModel(supply));
    }

}
