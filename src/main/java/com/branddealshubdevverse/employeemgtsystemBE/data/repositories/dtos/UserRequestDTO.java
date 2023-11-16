package com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos;

import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.models.User;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserRequestDTO {
    private  String username;
    private  String firstname;
    private  String lastname;
    private String email;
    private String password;
}
