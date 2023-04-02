package com.example.backendb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import jakarta.servlet.*;

@SpringBootApplication
public class BackendBApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackendBApplication.class, args);

    }
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> registrationBean =
                new FilterRegistrationBean<>(new CorsFilter());
        registrationBean.setOrder(0);
        return registrationBean;
    }
}
