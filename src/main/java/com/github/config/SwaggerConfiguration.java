package com.github.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.github.controller")).paths(PathSelectors.any()).build()
				.useDefaultResponseMessages(false).apiInfo(apiInfo()).pathMapping("/");
	}

	private ApiInfo apiInfo() {
		StringBuilder description = new StringBuilder();
		description.append("This is Gateway API.");
		return new ApiInfoBuilder().title("Gateway API").version("1.0.0").description(description.toString())
				.build();
	}
}
