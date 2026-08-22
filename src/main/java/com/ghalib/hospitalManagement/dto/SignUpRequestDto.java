package com.ghalib.hospitalManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SignUpRequestDto {
    private String username;
    private String password;
    private String email;
}
