package com.example.user.dto;

import lombok.Data;

@Data
public class UserDeleteRequestDto {
    private String username;
    private Long phoneNo;
}
