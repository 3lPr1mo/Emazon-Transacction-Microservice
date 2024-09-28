package com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.repository;

import com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {
}
