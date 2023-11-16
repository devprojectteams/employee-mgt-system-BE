package com.branddealshubdevverse.employeemgtsystemBE.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcWebConfigurer implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/users")
                .allowedOriginPatterns("http://localhost:3000/")
                .allowCredentials(true);
    }
}


