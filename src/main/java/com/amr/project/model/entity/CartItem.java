package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
@Data
@Builder
public class CartItem {
    //TODO товары в корзине, продумать какие поля им нужны, нужны-ли связи?
    private Long id;
    private String anonID;
    private int quantity;
}
