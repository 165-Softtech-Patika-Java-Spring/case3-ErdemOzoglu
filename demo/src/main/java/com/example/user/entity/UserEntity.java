package com.example.user.entity;

import com.example.user.enums.UserType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @SequenceGenerator(name = "UserEntity", sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "UserEntity")
    private Long id;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "PHONE_NO", unique = true)
    private Long phoneNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE")
    private UserType userType;

}
