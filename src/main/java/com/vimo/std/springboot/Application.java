package com.vimo.std.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        // springboot의 entry point로 프로젝트의 최상단에 위치해야 함
        SpringApplication.run(Application.class, args);
    }
}
