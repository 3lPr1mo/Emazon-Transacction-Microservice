package com.bootcamp.pragma.transactionmicroservice.application.dto.request;

import com.bootcamp.pragma.transactionmicroservice.application.constant.StockConstants;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddStockArticleRequest {
    @Positive(message = StockConstants.ARTICLE_ID_IS_MANDATORY)
    private Long articleId;

    @Positive(message = StockConstants.QUANTITY_MUST_BE_POSITIVE)
    private Integer quantity;
}
