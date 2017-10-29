package com.ljd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@SpringBootApplication
public class Test {

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

    @RequestMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext applicationContext) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot");
            String[] beanNames = applicationContext.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
