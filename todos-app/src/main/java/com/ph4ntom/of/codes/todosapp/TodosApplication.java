package com.ph4ntom.of.codes.todosapp;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.DatabasePopulator;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
// @EnableR2dbcRepositories
@SpringBootApplication
public class TodosApplication {

  public static void main(final String[] arguments) {

    SpringApplication.run(TodosApplication.class, arguments);
  }

  @Bean
  protected ConnectionFactoryInitializer initializer(final ConnectionFactory factory) {

    final ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();

    final Resource resource = new ClassPathResource("schema.sql");
    final DatabasePopulator populator = new ResourceDatabasePopulator(resource);

    initializer.setConnectionFactory(factory);
    initializer.setDatabasePopulator(populator);

    return initializer;
  }
}
