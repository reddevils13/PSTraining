package com.otp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.RequestHandledEvent;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/* Change author accordingly
 * Author - Aritra*/


//http://localhost:<port-number>/swagger-ui.html#/ to visit swagger-ui 


@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket apiDocimentation() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.otp"))
				.paths(PathSelectors.any())
				.build();
	}
}
