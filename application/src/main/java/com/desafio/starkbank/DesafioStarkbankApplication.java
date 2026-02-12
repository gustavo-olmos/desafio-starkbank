package com.desafio.starkbank;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DesafioStarkbankApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioStarkbankApplication.class, args);
    }

}
