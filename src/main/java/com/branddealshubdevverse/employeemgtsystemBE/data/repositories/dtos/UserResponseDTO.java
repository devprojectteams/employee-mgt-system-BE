package com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserResponseDTO {


    private  String username;
    private  String firstname;
    private  String lastname;
    private String email;
    private String message;

}
