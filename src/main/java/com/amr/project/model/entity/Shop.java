package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String description;

    private Long countryId;

    @OneToMany (mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Item> items;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logo_id")
    private Image logo;
    private int count;
    private double rating;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @OneToMany (mappedBy = "shop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Discount> discounts;

    private boolean isModerated = false;
    private boolean isModerateAccept = false;
    private String moderatedRejectReason;
    private boolean isPretendentToBeDeleted = false;
}
