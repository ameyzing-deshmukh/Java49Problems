package org.problems.graphql.simple.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String name;
    private BigDecimal cost;

    public BookEntity(String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
    }
}
