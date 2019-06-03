package com.jland.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring/queryContext.xml")
public class JLandWebSiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(JLandWebSiteApplication.class, args);
    }
}
