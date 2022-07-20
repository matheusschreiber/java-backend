package com.example.demo.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(CourseRepository repository) {
        return args -> {
            Course EngComp = new Course("Engenharia da Computação", 12345);
            Course EngMec = new Course("Engenharia Mecânica", 54321);

            repository.saveAll(
                List.of(EngComp, EngMec)
            );
        };

    }
}
