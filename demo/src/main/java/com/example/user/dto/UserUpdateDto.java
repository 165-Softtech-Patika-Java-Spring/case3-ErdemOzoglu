package com.example.user.dto;

import com.example.user.enums.UserType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class UserUpdateDto {

    private Long id;
    private String username;
    private String email;
    private Long phoneNo;
    private UserType userType;

}
