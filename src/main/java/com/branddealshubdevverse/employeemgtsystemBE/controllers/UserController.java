package com.branddealshubdevverse.employeemgtsystemBE.controllers;

import com.branddealshubdevverse.employeemgtsystemBE.Utils.Exceptions.ResponseUtils;
import com.branddealshubdevverse.employeemgtsystemBE.Utils.Exceptions.UserNotFoundException;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos.ApiResponse;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos.UserRequestDTO;
//import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos.UserResponseBuilder;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos.UserResponseDTO;
import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.models.User;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    //private final UserResponseBuilder userResponseBuilder;

    @PostMapping("create_user")
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);
        ApiResponse apiResponse = ResponseUtils.getCreationSuccessfulMessage();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("get_user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }
        @PatchMapping("update_user/{id}")
        public ResponseEntity<ApiResponse> updateUser(@RequestBody JsonPatch jsonPatch,
                                                         @PathVariable Long id) {
        userService.updateUserProfile(id, jsonPatch);
       ApiResponse apiResponse = ResponseUtils.updateUser();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }

        @DeleteMapping("delete_user/{id}")
        public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id){
                userService.deleteUserById(id);
                ApiResponse apiResponse = ResponseUtils.deleteMessage();
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
        }

}
//
//@RestController
//@RequestMapping("/users")
//@CrossOrigin("*")
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//
//    @PostMapping
//    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
//        UserResponse userResponse = new UserResponse();
//        userResponse.setMessage(userService.createUser(userRequest));
//        return ResponseEntity.ok(userResponse);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        List<UserResponse> usersResponse = userService.findAllUsers();
//        return ResponseEntity.ok(usersResponse);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
//        UserResponse userResponse;
//        try {
//            userResponse = userService.getUserById(id);
//        } catch (UserNotFoundException ex) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(userResponse);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest, @PathVariable Long id) {
//        UserResponse userResponse = new UserResponse();
//        userResponse.setMessage(userService.updateUser(userRequest, id));
//        return ResponseEntity.ok(userResponse);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) throws UserNotFoundException {
//        UserResponse userResponse = new UserResponse();
//        userResponse.setMessage(userService.deleteUser(id));
//        return ResponseEntity.ok(userResponse);
//    }
//}