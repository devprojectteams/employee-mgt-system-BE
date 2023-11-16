package com.branddealshubdevverse.employeemgtsystemBE.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String message;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
}
