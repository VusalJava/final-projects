package com.amr.project.model.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "image")
@Data
@Builder
public class Image {
    //TODO картинки будем хранить в БД (для удобства, хотя это и плохая практика)
    private Long id;
    private byte[] picture;
    private Boolean isMain = false;
}
