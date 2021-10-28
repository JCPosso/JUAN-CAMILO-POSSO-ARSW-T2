package edu.eci.arsw.coronavirus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.coronavirus"})
public class CoronavirusApp {
    public static void main(String[] args) {
        SpringApplication.run(CoronavirusApp.class, args);
        System.out.println("Hello word!");
    }
}