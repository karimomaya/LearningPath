package com.learning;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

/**
 * Created by karim on 4/15/20.
 */
@EnableJpaRepositories("com.learning.repository")
@EnableJpaAuditing

@EntityScan("com.learning")
@SpringBootApplication
@ComponentScan("com.learning")
//@EnableCaching
public class SpringBootRestServiceApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootRestServiceApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8080"));
        app.run(args);
    }

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/*").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
            }
        };
    }
}
