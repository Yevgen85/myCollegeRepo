package com.example.mycollege.myConigurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
