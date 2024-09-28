package com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.mapper;

import com.bootcamp.pragma.transactionmicroservice.domain.model.Supply;
import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.entity.SupplyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISupplyEntityMapper {
    SupplyEntity toEntityFromModel(Supply supply);
    Supply toModelFromEntity(SupplyEntity supplyEntity);
}
