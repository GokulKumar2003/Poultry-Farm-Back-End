package com.PF.PoultryFarm.service;

import com.PF.PoultryFarm.dao.UserRepository;
import com.PF.PoultryFarm.entity.User;
import java.util.Collections;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = this.userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User does not exist");
        } else {
            return new org.springframework.security.core.userdetails.User(((User)user.get()).getUsername(), ((User)user.get()).getPassword(), Collections.emptyList());
        }
    }
}
