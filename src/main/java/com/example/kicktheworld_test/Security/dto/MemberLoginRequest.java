package com.example.kicktheworld_test.Security.dto;

import lombok.Data;

@Data
public class MemberLoginRequest {
    private String memId;
    private String password;
}
