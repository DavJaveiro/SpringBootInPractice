package com.manning.sbip.ch06.service.impl;

import com.manning.sbip.ch06.model.ApplicationUser;
import com.manning.sbip.ch06.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = userService.findByUsername(username);
        if(applicationUser == null) {
            throw new UsernameNotFoundException("User with username" + username + " not found" + " does not exist");
        }

        // We are returning a Spring Security UserDetails instace created from the custom ApplicxationUser class
        UserDetails userDetails = User.withUsername(username).password(applicationUser.getPassword()).roles("USER").disabled(false).build();

        return userDetails;
    }
}
