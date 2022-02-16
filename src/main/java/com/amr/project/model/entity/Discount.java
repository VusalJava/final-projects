package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "discount")
@Data
@Builder
public class Discount {
    //TODO скидка для постоянного покупателя
    private Long id;
    private int minOrder;
    private int percentage;
    private User user;
}
