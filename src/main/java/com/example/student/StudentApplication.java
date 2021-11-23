package com.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Configuration
    public class WebMvcConfiguration implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200")
			.allowCredentials(true)
			.allowedMethods("GET","POST","DELETE","PUT","PATCH","OPTIONS","HEAD")
			.allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers","*");
            // allowedOrigins("*").
            // allowedMethods("*").
            // allowedHeaders("*").
            // allowCredentials(true); 
        }
    }

}
