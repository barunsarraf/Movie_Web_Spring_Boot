package com.stackroute.services;

import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistException;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices{

    @Autowired
    DataSource dataSource;
    UserRepository userRepository;
    @Autowired
    public UserServicesImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistException {
        if(userRepository.existsById(user.getId())){
            throw new UserAlreadyExistException("User Already Exist");
        }
        User savedUser=userRepository.save(user);
        if(savedUser==null){
            throw new UserAlreadyExistException("User Already Exist");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
