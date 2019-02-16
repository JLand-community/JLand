package com.jland.website.service.impl;

import com.jland.website.model.User;
import com.jland.website.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @Test
    void testFindUserByUsernameNegative() {
        UserRepository mockUserRepository = mock(UserRepository.class);

        when(mockUserRepository.findByUsername("UserNameForTest")).thenReturn(Optional.empty());
        UserServiceImpl userService = new UserServiceImpl(mockUserRepository);

        Exception exception = assertThrows(UsernameNotFoundException.class, () -> userService.findUserByUsername("UserNameForTest"));
        assertEquals("UserNameForTest", exception.getMessage());
    }


    @Test
    void testFindUserByUsernamePositive() throws Exception {
        UserRepository mockUserRepository = mock(UserRepository.class);
        User user = new User();
        user.setId(1L);

        when(mockUserRepository.findByUsername("UserNameForTest")).thenReturn(Optional.of(user));
        UserServiceImpl userService = new UserServiceImpl(mockUserRepository);
        User actual = userService.findUserByUsername("UserNameForTest");

        assertEquals(user.getId(), actual.getId());
    }

}