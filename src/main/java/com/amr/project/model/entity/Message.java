package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "message")
@Data
@Builder
public class Message {
    private Long id;
    private Chat chat;
    private User to;
    private User from;
    private String textMessage;
    private boolean viewed;
}
