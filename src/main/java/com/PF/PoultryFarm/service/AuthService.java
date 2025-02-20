package com.PF.PoultryFarm.service;

import com.PF.PoultryFarm.dao.UserRepository;
import com.PF.PoultryFarm.dto.LoginRequest;
import com.PF.PoultryFarm.dto.LoginResponse;
import com.PF.PoultryFarm.entity.User;
import com.PF.PoultryFarm.security.JwtUtil;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public LoginResponse login(LoginRequest request) {
        Optional<User> user = this.userRepository.findByUsername(request.getUsername());
        if (user.isPresent() && request.getPassword().equals(((User)user.get()).getPassword())) {
            String token = this.jwtUtil.generateToken(((User)user.get()).getUsername());
            return new LoginResponse(token);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
