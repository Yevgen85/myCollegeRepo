package com.example.mycollege.service;

import com.example.mycollege.beans.Login;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean loginCheck(String login, String password) {
        return login.contains(Login.login) && password.contains(Login.password);
    }
}
