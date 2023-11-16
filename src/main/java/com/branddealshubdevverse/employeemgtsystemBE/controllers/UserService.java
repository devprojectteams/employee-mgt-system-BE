package com.branddealshubdevverse.employeemgtsystemBE.controllers;

import com.branddealshubdevverse.employeemgtsystemBE.Utils.Exceptions.UserNotFoundException;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos.UserRequestDTO;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos.UserResponseDTO;
import com.branddealshubdevverse.employeemgtsystemBE.requests.UserRequest;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.models.User;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface UserService {
        void createUser(UserRequestDTO userRequest);

        List<User> findAllUsers();

        User findUserById(Long id);

//        User updateUser(User updatedUser, Long id);
        void updateUserProfile(Long userId, JsonPatch jsonPatch) throws UserNotFoundException;

        void deleteUserById(Long id);
//        UserResponseDTO mapUserToDto(User user);
}