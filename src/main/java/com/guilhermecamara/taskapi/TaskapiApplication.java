package com.guilhermecamara.taskapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages = {"com.guilhermecamara.taskapi.model"})
@ComponentScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages = {"com.guilhermecamara.taskapi.repository"})
@EnableWebMvc
@RestController
public class TaskapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskapiApplication.class, args);
    }

}
