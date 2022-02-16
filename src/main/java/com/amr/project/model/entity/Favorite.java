package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "favorite")
@Data
@Builder
public class Favorite {
    //TODO избранные товары пользователя
    private Long id;
    private Long itemId;
    private User user;
}