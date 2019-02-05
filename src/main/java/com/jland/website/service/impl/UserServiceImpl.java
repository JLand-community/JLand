package com.jland.website.service.impl;


import com.jland.website.model.User;
import com.jland.website.repository.UserRepository;
import com.jland.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


/*    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("user"));

       String encodedPassword = "$2a$10$QyLX53D3T/2gpICovAYn8e0Y2aAPaOFXvuZP52hIB3wL/eYDcHzfa";

    }*/
}
