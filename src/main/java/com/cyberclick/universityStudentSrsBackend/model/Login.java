package com.cyberclick.universityStudentSrsBackend.model;

public class Login {
    private String usernameOrEmail;
    private String password;

    public Login(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }
}
