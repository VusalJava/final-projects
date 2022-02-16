package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@Data
@Builder
public class Address {
    private Long id;
    private String cityIndex;
    private City city;
    private String street;
    private String house;
    private User user;
}
