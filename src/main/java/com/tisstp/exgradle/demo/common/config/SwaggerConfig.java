package com.tisstp.exgradle.demo.common.config;


import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import io.swagger.annotations.Api;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
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
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(apis())
        .paths(paths())
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

//  @Bean
//  public Docket petApi() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .groupName("full-petstore-api")
//        .apiInfo(apiInfo())
//        .select()
//        .paths(petstorePaths())
//        .build()
//        .securitySchemes(newArrayList(oauth()))
//        .securityContexts(newArrayList(securityContext()))
//        ;
//  }

//  @Bean
//  public SecurityScheme oauth() {
//    return new OAuthBuilder()
//        .name("petstore_auth")
//        .grantTypes(grantTypes())
//        .scopes(scopes())
//        .build();
//  }

//  @Bean
//  public SecurityContext securityContext() {
//    AuthorizationScope readScope = new AuthorizationScope("read:pets", "read your pets");
//    AuthorizationScope[] scopes = new AuthorizationScope[1];
//    scopes[0] = readScope;
//    SecurityReference securityReference = SecurityReference.builder()
//        .reference("petstore_auth")
//        .scopes(scopes)
//        .build();
//
//    return SecurityContext.builder()
//        .securityReferences(newArrayList(securityReference))
//        .forPaths(ant("/api/pet.*"))
//        .build();
//  }

//  private Predicate<String> petstorePaths() {
//    return PathSelectors.any();
//    return or(
//        regex("/api/pet.*"),
//        regex("/api/user.*"),
//        regex("/api/store.*")
//    );
//  }

}
