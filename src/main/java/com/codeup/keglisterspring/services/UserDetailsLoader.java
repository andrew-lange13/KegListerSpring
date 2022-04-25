package com.codeup.keglisterspring.services;

import com.codeup.keglisterspring.models.User;
import com.codeup.keglisterspring.models.UserWithRoles;
import com.codeup.keglisterspring.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsLoader implements UserDetailsService {

    public final UserRepository users;

    public UserDetailsLoader(UserRepository users){
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("No user found for " + username);
        }
        return new UserWithRoles(user);
    }
}
