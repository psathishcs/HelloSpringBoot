package org.hello.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("org.hello.boot.controller"))
	      .paths(PathSelectors.ant("/hello/*"))
	      .build()
	      .apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo(
	      "HelloSpringBoot- Docker",
	      "Simple Spring Boot that connect to the Oralce 11g database get the employee and its deployed in Docker container.",
	      "1.0.0",
	      "Terms of service",
	      new Contact("Sathish Kumar Parthasarathy", "https://github.com/psathishcs", "p.sathish.cs@gmail.com"),
	      "License of API",
	      "API license URL");
	    return apiInfo;
	}
}
