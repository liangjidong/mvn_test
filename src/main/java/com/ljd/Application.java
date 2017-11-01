package com.ljd;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
// 将使用@SpringBootApplication的类放在根包下，默认该包以及子包中的类有某些注解会被自动扫描@Entity，@Controller
// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
//@EnableAutoConfiguration
public class Application {

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

    @RequestMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    public static void main(String[] args) {
        //默认
        //SpringApplication.run(Application.class, args);
        //自定义---在启动的时候将Spring的图像去掉
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
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
