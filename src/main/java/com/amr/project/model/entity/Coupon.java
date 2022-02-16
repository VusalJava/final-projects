package com.amr.project.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
@Data
public class Coupon {
    //TODO разовый скидочный купон для покупателя, добавить поля
    private Long id;
}
