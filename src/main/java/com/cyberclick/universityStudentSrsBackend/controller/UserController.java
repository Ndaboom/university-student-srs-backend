package com.cyberclick.universityStudentSrsBackend.controller;

import com.cyberclick.universityStudentSrsBackend.entity.AuthRequest;
import com.cyberclick.universityStudentSrsBackend.entity.UserInfo;
import com.cyberclick.universityStudentSrsBackend.response.ResponseHandler;
import com.cyberclick.universityStudentSrsBackend.service.JwtService;
import com.cyberclick.universityStudentSrsBackend.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome! This endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public ResponseEntity<Object> addNewUser(@RequestBody UserInfo userInfo) {
        return ResponseHandler.responseBuilder("Registration succeeded",  HttpStatus.OK,  service.addUser(userInfo));
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public ResponseEntity<Object> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return ResponseHandler.responseBuilder("Authentication succeded",  HttpStatus.OK,  jwtService.generateToken(authRequest.getUsername()));
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
