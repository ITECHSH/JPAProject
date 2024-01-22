package ru.neoflex.springbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.neoflex")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
