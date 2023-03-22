package com.example.mycollege.controller;

import com.example.mycollege.beans.AdminUser;
import com.example.mycollege.beans.Login;
import com.example.mycollege.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping()
    public AdminUser isExist(@RequestBody AdminUser adminUser) throws SQLException {
        AdminUser adminToReturn = new AdminUser();
        return loginService.loginCheck(adminUser.login, adminUser.password) ? adminToReturn : null;
    }

}
