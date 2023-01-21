package com.bridgelabz.bookstoreapplication.Config;


import com.bridgelabz.bookstoreapplication.Util.JwtToken;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Bean
    public JwtToken jwTtoken() {

        return new JwtToken();
    }

}
