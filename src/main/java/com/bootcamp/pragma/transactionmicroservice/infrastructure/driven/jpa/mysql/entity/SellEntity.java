package com.bootcamp.pragma.transactionmicroservice.infrastructure.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "sell")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "article_id", nullable = false)
    private Long articleId;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "_date")
    private LocalDateTime date;

}
