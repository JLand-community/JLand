package com.jland.website.service;

import com.jland.website.model.User;

public interface UserService {

    User findUserByUsername(String username);

}
