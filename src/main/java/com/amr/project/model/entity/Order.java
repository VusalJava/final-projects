package com.amr.project.model.entity;

import com.amr.project.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name="order_items", joinColumns=@JoinColumn(name="order_id"))
    @Column(name="item_id")
    private List<Long> itemsId;

    private Calendar date;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    private Long address;

    private BigDecimal total;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    private String buyerName;
    private String buyerPhone;
}
