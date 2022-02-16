package com.amr.project.model.entity;

import com.amr.project.model.enums.Status;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
public class Order {
    private Long id;
    private List<Item> items;
    private Calendar date;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    private Address address;
    private BigDecimal total;
    private User user;
    private String buyerName;
    private String buyerPhone;
}
