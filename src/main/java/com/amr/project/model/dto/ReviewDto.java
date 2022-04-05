package com.amr.project.model.dto;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

@Data
@ToString
public class ReviewDto {
    private Long id;
    private String dignity;
    private String flaw;
    private String text;
    private Date date;
    private int rating;
    private String nameUser;
    private Long itemId;
    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
}
