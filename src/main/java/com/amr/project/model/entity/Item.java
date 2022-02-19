package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "item")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal basePrice;
    private BigDecimal price;
    private Long categoryId;

    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "item_image", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns
            = @JoinColumn(name = "image_id"))
    private List<Image> images;

    @OneToMany (mappedBy = "item" , cascade = CascadeType.ALL)
    private List<Review> reviews;

    private int count;
    private double rating;
    private String description;
    private int discount;

    @ManyToOne
    @JoinColumn (name = "shop_id")
    private Shop shop;

    private boolean isModerated = false;
    private String moderatedRejectReason;
    private boolean isPretendedToBeDeleted;
}
