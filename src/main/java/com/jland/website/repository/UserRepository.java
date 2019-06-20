package com.jland.website.repository;

import com.jland.website.model.User;
import com.jland.website.model.UserDetailsImpl;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<UserDetailsImpl> findByUsername(String username);

    Optional<User> findByUsernameAndConferenceId(String username, long conferenceId);

    Optional<User> findByIdAndConferenceId(long id, long conferenceId);

    List<User> getAll(long conferenceId);

}
