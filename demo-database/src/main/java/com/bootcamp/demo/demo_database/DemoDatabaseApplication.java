package com.bootcamp.demo.demo_database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ! @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication 
public class DemoDatabaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoDatabaseApplication.class, args);
  }

}
