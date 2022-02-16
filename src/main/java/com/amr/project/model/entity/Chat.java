package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "chat")
@Data
@Builder
public class Chat {
    private Long id;
    private List<User> members;
    private List<Message> messages;
    private Long hash;

    public Chat(List<User> members) {
        this.members = members;
        this.hash = members.stream().map(User::hashCode).mapToLong(e -> e).sum();
    }
}
