package com.branddealshubdevverse.employeemgtsystemBE.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
