package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dignity;
    private String flaw;
    private String text;
    private Date date;
    private int rating;

    private String nameUser;

    @ManyToOne
    @JoinColumn (name = "item_id")
    private Item item;

    private boolean isModerated = false;
    private boolean isModerateAccept = false;
    private String moderatedRejectReason;
}
