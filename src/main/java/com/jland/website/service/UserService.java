package com.jland.website.service;

import com.jland.website.model.User;
import com.jland.website.model.UserDetailsImpl;

import java.util.List;

public interface UserService {

    UserDetailsImpl findUserByUsername(String username);

    User findByUsernameAndConferenceId(String username, long conferenceId);
    User findByIdAndConferenceId(long id, long conferenceId);

    List<User> getAll(long conferenceId);


}
