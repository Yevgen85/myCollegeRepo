package com.example.mycollege.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Component

public class Login {
    public static final String login = "ADMIN";
    public static final String password = "12345";

}
