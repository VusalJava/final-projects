package com.amr.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chat")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany (fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinTable(name = "chat_members", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns
            = @JoinColumn(name = "members_id"))
    private List<User> members;  // что имеется ввиду под чатом?

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Message> messages;

//    @Column(name = "hash")
//    private Long hash;

    public Chat(List<User> members) {
        this.members = members;
//        this.hash = members.stream().map(User::hashCode).mapToLong(e -> e).sum();
    }
}
