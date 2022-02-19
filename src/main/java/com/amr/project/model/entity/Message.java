package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "message")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "chat_id")
    private Chat chat;

    @OneToOne
    @JoinColumn(name = "user_to")
    private User to;

    @OneToOne
    @JoinColumn(name = "user_from")
    private User from;

    private String textMessage;
    private boolean viewed;
}
