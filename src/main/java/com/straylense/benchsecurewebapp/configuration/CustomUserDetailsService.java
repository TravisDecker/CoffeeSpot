package com.straylense.benchsecurewebapp.configuration;

import com.straylense.benchsecurewebapp.model.User;
import com.straylense.benchsecurewebapp.repos.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(CustomUserDetail::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
