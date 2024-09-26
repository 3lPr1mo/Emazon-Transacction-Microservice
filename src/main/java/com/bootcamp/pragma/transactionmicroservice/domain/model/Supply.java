package com.bootcamp.pragma.transactionmicroservice.domain.model;

import java.time.LocalDateTime;

public class Supply {
    private Long id;
    private Long userId;
    private Long articleId;
    private LocalDateTime date;

    public Supply(Long id, Long userId, Long articleId, LocalDateTime date) {
        this.id = id;
        this.userId = userId;
        this.articleId = articleId;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
