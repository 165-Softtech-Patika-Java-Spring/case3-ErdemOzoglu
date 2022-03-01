package com.example.user.dto;

import lombok.Data;

@Data
public class UserDeleteResponseDto {
    private String username;
    private Long phoneNo;
    private String errorMessage;
}
