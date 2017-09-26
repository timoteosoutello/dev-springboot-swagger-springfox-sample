package com.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class SpringExecutor extends SpringBootServletInitializer
    implements WebApplicationInitializer {
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(SpringExecutor.class);
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(SpringExecutor.class, args);
  }
}
