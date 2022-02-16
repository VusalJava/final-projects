package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Data
@Builder
@Table(name = "feedback")
public class Feedback {
    //TODO обратная связь от покупателей (книга жалоб и предложений :))
    private Long id;
    private String reason;
    private String fullText;
    private LocalDateTime dateTime;
    private String username;
}