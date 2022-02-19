package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Builder
@Table(name = "feedback")
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    //TODO обратная связь от покупателей (книга жалоб и предложений :))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;
    private String fullText;
    private LocalDateTime dateTime;
    private String username;


}