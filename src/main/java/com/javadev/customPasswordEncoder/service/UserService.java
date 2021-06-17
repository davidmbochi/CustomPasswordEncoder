package com.javadev.customPasswordEncoder.service;

import com.javadev.customPasswordEncoder.encoder.CustomPasswordEncoder;
import com.javadev.customPasswordEncoder.model.User;
import com.javadev.customPasswordEncoder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {


    private UserRepository userRepository;
    private CustomPasswordEncoder customPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       @Lazy CustomPasswordEncoder customPasswordEncoder){
        this.userRepository = userRepository;
        this.customPasswordEncoder = customPasswordEncoder;

    }


    public void registerUser(User user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(customPasswordEncoder.encode(user.getPassword()));
        userRepository.save(newUser);

    }

    public User findUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("user not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),Collections.emptyList());

    }


}
