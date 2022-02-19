package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cart_items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    //TODO товары в корзине, продумать какие поля им нужны, нужны-ли связи?
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

//    @OneToOne
//    @JoinColumn (name = "shop_id")
//    private Shop shop;

    @OneToOne
    @JoinColumn (name = "item_id")
    private Item item;

//    public double getSubTotal(Discount discount, Coupon coupon) {
//
//    }


}
