package com.jland.website.repository;

import com.jland.website.model.User;

public interface UserRepository {

    User findByUsername(String username);
}
