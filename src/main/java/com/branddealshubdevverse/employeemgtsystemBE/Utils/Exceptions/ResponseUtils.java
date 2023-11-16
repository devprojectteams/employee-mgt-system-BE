package com.branddealshubdevverse.employeemgtsystemBE.Utils.Exceptions;

import com.branddealshubdevverse.employeemgtsystemBE.data.repositories.dtos.ApiResponse;
import org.springframework.http.HttpStatus;

import static com.branddealshubdevverse.employeemgtsystemBE.common.Messages.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public class ResponseUtils {
    public static ApiResponse getCreationSuccessfulMessage(){
        return ApiResponse.builder()
                .message(USER_CREATED)
                .success(true)
                .statusCode(CREATED.value())
                .build();
    }
    public static  ApiResponse getFindByIdFailureMessage(){
        return ApiResponse.builder()
                .message(USER_NOT_FOUND_BY_ID)
                .success(false)
                .statusCode(NOT_FOUND.value())
                .build();
    }

    public static ApiResponse updateUser(){
        return ApiResponse.builder()
                .message(USER_UPDATED)
                .success(true)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    public static ApiResponse deleteMessage(){
        return ApiResponse.builder()
                .message(DELETED)
                .success(true)
                .statusCode(HttpStatus.OK.value())
                .build();
    }
}
