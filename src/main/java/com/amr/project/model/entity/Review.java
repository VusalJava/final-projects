package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "review")
@Data
@Builder
public class Review {
    private Long id;
    private String dignity; //плюсы
    private String flaw; //минусы
    private String text;
    private Date date;
    private int rating;
    private User user;
    private Shop shop;
    private Item item;
    private boolean isModerated = false;
    private boolean isModerateAccept = false;
    private String moderatedRejectReason;
}
