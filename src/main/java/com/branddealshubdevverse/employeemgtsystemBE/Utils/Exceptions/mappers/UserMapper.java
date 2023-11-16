package com.branddealshubdevverse.employeemgtsystemBE.Utils.Exceptions.mappers;

import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos.UserResponseDTO;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.models.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserMapper {

    public UserResponseDTO mapToDTO(User user){
        UserResponseDTO userDto = new UserResponseDTO();
        userDto.setEmail(user.getEmail());
        userDto.setFirstname(userDto.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setUsername(user.getUsername());
    return userDto;
    }
}
