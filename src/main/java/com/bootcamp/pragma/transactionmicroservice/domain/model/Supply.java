package com.bootcamp.pragma.transactionmicroservice.domain.model;

import java.time.LocalDateTime;

public class Supply {
    private Long id;
    private Long articleId;
    private int quantity;
    private LocalDateTime date;
    private LocalDateTime restockDate;

    public Supply(Long id, Long articleId, int quantity, LocalDateTime date, LocalDateTime restockDate) {
        this.id = id;
        this.articleId = articleId;
        this.quantity = quantity;
        this.date = date;
        this.restockDate = restockDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getRestockDate() {
        return restockDate;
    }

    public void setRestockDate(LocalDateTime restockDate) {
        this.restockDate = restockDate;
    }
}
