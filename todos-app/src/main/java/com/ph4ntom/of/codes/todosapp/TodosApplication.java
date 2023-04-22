package com.ph4ntom.of.codes.todosapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class TodosApplication {

  public static void main(final String[] arguments) {

    SpringApplication.run(TodosApplication.class, arguments);
  }
}
