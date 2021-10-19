package com.kodluyoruz.HW3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class GeneralConfigrations {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
}
