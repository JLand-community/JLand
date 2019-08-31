package com.jland.website.service.impl;

import com.jland.website.exception.EntityNotFoundException;
import com.jland.website.model.User;
import com.jland.website.model.UserDetailsImpl;
import com.jland.website.repository.UserRepository;
import com.jland.website.service.UserService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailsImpl findUserByUsername(String username) {
        Optional<UserDetailsImpl> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException(username);
    }

    @Override
    public User findByUsernameAndConferenceId(String username, long conferenceId) {
        Optional<User> user = userRepository.findByUsernameAndConferenceId(username, conferenceId);
        if(user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException(username);
    }

    @Override
    public User findByIdAndConferenceId(long id, long conferenceId) {
        Optional<User> user = userRepository.findByIdAndConferenceId(id, conferenceId);
        if(user.isPresent()) {
            return user.get();
        }
        throw new EntityNotFoundException("User wasn't found by id: " + id + " and conferenceId: " + conferenceId);
    }

    @Override
    public List<User> getAll(long conferenceId) {
        return userRepository.getAll(conferenceId);
    }

}
