package com.stackroute.services;

import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserServices {
    public User saveUser(User user) throws UserAlreadyExistException;
    public List<User> getAllUsers();
}
