package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "coupon")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    //TODO разовый скидочный купон для покупателя, добавить поля
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int sum; // + сумма

    private int minOrder; // + минимальная стоимость корзины

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Long shopId;

}
