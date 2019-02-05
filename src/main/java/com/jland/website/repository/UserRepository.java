package com.jland.website.repository;

import com.jland.website.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserRepository {

    User findByUsername(String username);
}
