package com.bridgelabz.bookstoreapplication.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class LogIn {

    private String email;

    private String password;

    public LogIn() {
    }

    public LogIn(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
