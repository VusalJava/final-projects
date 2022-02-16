package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "city")
@Data
@Builder
public class City {
    private Long id;
    private String name;
    private Country country;
    private List<Address> addresses;
}