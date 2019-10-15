package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistException;
import com.stackroute.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping(value = "api/v1")
public class UserController {
    UserServices userServices;

    @Autowired
    public UserController(UserServices userServices){
        this.userServices=userServices;
    }

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        ResponseEntity responseEntity;
        try{
            userServices.saveUser(user);
            responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        }
        catch (UserAlreadyExistException e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<List<User>>(userServices.getAllUsers(),HttpStatus.OK);
    }
}
