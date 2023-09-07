package com.cyberclick.universityStudentSrsBackend.controller;

import com.cyberclick.universityStudentSrsBackend.model.Login;
import com.cyberclick.universityStudentSrsBackend.response.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    @GetMapping("/")
    public String greeting(){
        return "Welcome to the URS Api!";
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Login login){
        return ResponseHandler.responseBuilder("Login", HttpStatus.OK, null);
    }
}
