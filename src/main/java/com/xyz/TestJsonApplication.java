package com.xyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.xyz"})
public class TestJsonApplication {

  private static ConfigurableApplicationContext context;

  public static void main ( String[] args ) {
    context = SpringApplication.run(TestJsonApplication.class, args);
  }

}
