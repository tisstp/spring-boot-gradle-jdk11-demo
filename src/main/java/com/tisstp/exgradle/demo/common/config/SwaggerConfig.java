package com.tisstp.exgradle.demo.common.config;


import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import io.swagger.annotations.Api;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sathaphorn.stp (Tis)
 * @since 18-12-2019, 12:48 PM
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.tisstp.exgradle.demo.api.swag.controllers")
public class SwaggerConfig {

  @Bean
  public Docket defaultApi() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .select()
      .apis(apis())
      .build();
  }

  @Bean
  public Docket categoryApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("category-api")
        .apiInfo(apiInfo())
        .select()
        .apis(apis())
        .paths(paths())
        .build();
  }

  @Bean
  public Docket multipartApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("multipart-api")
        .apiInfo(apiInfo())
        .select()
        .apis(apis())
        .paths(multipartPaths())
        .build();
  }

  private Predicate<RequestHandler> apis() {
    return RequestHandlerSelectors.withClassAnnotation(Api.class);
  }

  private Predicate<String> paths() {
    return or(
        regex("/category.*"),
        regex("/category"),
        regex("/categories")
    );
  }

  private Predicate<String> multipartPaths() {
    return PathSelectors.regex("/upload.*");
  }


  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Springfox petstore API")
        .description("An Online Document Backend Interface")
        .termsOfServiceUrl("http://termsOfServiceUrl.com")
        .contact(new Contact("Sathaphorn.s", "https://github.com/tisstp", "sathaphorn.stp@gamil.com"))
        .license("Tis.stp License Version 1")
        .licenseUrl("http://license.com")
        .version("0.0.1")
        .build();
  }

}
