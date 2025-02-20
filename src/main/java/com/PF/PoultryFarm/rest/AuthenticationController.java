package com.PF.PoultryFarm.rest;

import com.PF.PoultryFarm.dto.LoginRequest;
import com.PF.PoultryFarm.dto.LoginResponse;
import com.PF.PoultryFarm.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
        origins = {"http://localhost:5173"}
)
@RequestMapping({"/api/1.0/auth"})
public class AuthenticationController {
    AuthService authService;

    @Autowired
    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping({"/login"})
    public LoginResponse login(@RequestBody LoginRequest request) {
        System.out.println(request.getPassword());
        System.out.println(request.getUsername());
        return this.authService.login(request);
    }
}

