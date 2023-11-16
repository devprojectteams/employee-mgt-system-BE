package com.branddealshubdevverse.employeemgtsystemBE.controllers;


import com.branddealshubdevverse.employeemgtsystemBE.Utils.Exceptions.UserNotFoundException;
import com.branddealshubdevverse.employeemgtsystemBE.Utils.Exceptions.mappers.UserMapper;
import com.branddealshubdevverse.employeemgtsystemBE.common.Messages;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.UserRepository;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos.UserRequestDTO;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos.UserResponseDTO;
import com.branddealshubdevverse.employeemgtsystemBE.requests.UserRequest;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.models.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserRequestDTO userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setFirstname(userRequest.getFirstname());
        user.setLastname(userRequest.getLastname());
        user.setUsername(userRequest.getUsername());
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
//
//    @Override
//    public UserResponseDTO mapUserToDto(User user) {
//        Optional<User> theUser = userRepository.findById(user.getId());
//        if (theUser.isEmpty()){
//            throw new UserNotFoundException("User not found");
//        }
//        UserMapper userMapper = new UserMapper();
//        userMapper.mapToDTO(theUser);
//        return null;
//    }
//    @Override
//    public User updateUser(User updatedUser, Long id) {
//        userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException(id));
//        updatedUser.setId(id); // set the ID of the updated user
//        return userRepository.save(updatedUser);
//    }

    @Override
    public void updateUserProfile(Long userId, JsonPatch jsonPatch) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            User updatedStudent = applyPatchToStudent(jsonPatch, user);
            userRepository.save(updatedStudent);
        }
        else {
            throw new UserNotFoundException(String.format(Messages.USER_NOT_FOUND_BY_ID));
        }
}

    private User applyPatchToStudent(JsonPatch jsonPatch, User user) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode patchedObject = jsonPatch.apply(objectMapper.convertValue(user, JsonNode.class));
            return objectMapper.treeToValue(patchedObject, User.class);
        }
        catch(JsonPatchException | IOException exception){
            throw new RuntimeException("Failed to apply patch to student", exception);
        }

    }


    @Override
    public void deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new UserNotFoundException("User not found");
        }
    }


}

