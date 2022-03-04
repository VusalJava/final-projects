package com.amr.project.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ImageDto {
    private Long id;
    private byte[] picture;
    private Boolean isMain;
}
