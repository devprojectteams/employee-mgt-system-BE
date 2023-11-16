package com.branddealshubdevverse.employeemgtsystemBE.controllers;



import com.branddealshubdevverse.employeemgtsystemBE.Utils.Exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(UserNotFoundException exception) {

        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error: ", exception.getMessage());

        return errorMap;
    }
}
