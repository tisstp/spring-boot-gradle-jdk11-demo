package com.tisstp.exgradle.demo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sathaphorn.stp (Tis)
 * @since 18-12-2019, 5:02 PM
 */
@Configuration
public class WebMvcConfig {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        // registry
           // .addMapping("/greeting-javaconfig")
           // .allowedOrigins("http://localhost:9000");
//        registry
//            .addMapping("/api/pet")
//            .allowedOrigins("http://editor.swagger.io");
//        registry
//            .addMapping("/v2/api-docs.*")
//            .allowedOrigins("http://editor.swagger.io");
      }
    };
  }

}
