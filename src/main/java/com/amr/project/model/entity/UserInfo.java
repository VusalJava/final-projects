package com.amr.project.model.entity;

import com.amr.project.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Calendar;

@Entity
@Table(name = "user_info")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"phone", "firstName", "lastName", "age", "gender", "birthday"})
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    private String phone;
    private String firstName;
    private String lastName;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Calendar birthday;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}