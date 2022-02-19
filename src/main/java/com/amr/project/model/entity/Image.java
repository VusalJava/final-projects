package com.amr.project.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    //TODO картинки будем хранить в БД (для удобства, хотя это и плохая практика)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte[] picture;
    private Boolean isMain = false;
}
