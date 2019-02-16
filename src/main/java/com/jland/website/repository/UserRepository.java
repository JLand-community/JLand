package com.jland.website.repository;

import com.jland.website.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUsername(String username);
}
