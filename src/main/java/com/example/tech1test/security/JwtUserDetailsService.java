package com.example.tech1test.security;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private static final String USERNAME = "tech1";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!USERNAME.equals(username)) {
            throw new UsernameNotFoundException("Not found user " + username);
        }
        return new User(USERNAME, "", new ArrayList<>());
    }
}
