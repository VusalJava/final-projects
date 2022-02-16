package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "item")
@Data
@Builder
public class Item {
    private Long id;
    private String name;
    private BigDecimal basePrice;
    private BigDecimal price;
    private Category category;
    private List<Image> images;
    private List<Review> reviews;
    private int count;
    private double rating;
    private String description;
    private int discount;
    private Shop shop;
    private boolean isModerated = false;
    private String moderatedRejectReason;
    private boolean isPretendedToBeDeleted;
}
