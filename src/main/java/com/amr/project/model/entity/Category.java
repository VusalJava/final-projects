package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@Data
@Builder
public class Category {
    private Long id;
    private String name;
}
