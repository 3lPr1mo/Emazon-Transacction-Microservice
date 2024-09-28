package com.bootcamp.pragma.transactionmicroservice.domain.usecase;

import com.bootcamp.pragma.transactionmicroservice.application.dto.response.StockResponse;
import com.bootcamp.pragma.transactionmicroservice.domain.api.usecase.SupplyUseCase;
import com.bootcamp.pragma.transactionmicroservice.domain.exception.StockMicroserviceException;
import com.bootcamp.pragma.transactionmicroservice.domain.model.Supply;
import com.bootcamp.pragma.transactionmicroservice.domain.spi.IMStockPersistencePort;
import com.bootcamp.pragma.transactionmicroservice.domain.spi.ISupplyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class SupplyUseCaseTest {

    @Mock
    private ISupplyPersistencePort supplyPersistencePort;
    @Mock
    private IMStockPersistencePort stockPersistencePort;
    private SupplyUseCase supplyUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        supplyUseCase = new SupplyUseCase(supplyPersistencePort, stockPersistencePort);
    }

    @Test
    void shouldSaveSupplySuccessfully() {
        Supply supply = new Supply(null, 1L, 10, LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
        when(stockPersistencePort.addStockToArticle(supply)).thenReturn(new StockResponse(true));
        supplyUseCase.saveSupply(supply);
        verify(supplyPersistencePort, times(1)).saveSupply(supply);
    }

    @Test
    void shouldThrowExceptionWhenStockMicroserviceStatusIsFalse() {
        Supply supply = new Supply(null, 1L, 10, LocalDateTime.now(), LocalDateTime.now().plusMonths(1));
        when(stockPersistencePort.addStockToArticle(supply)).thenReturn(new StockResponse(false));
        assertThrows(StockMicroserviceException.class, () -> supplyUseCase.saveSupply(supply));
    }

}
