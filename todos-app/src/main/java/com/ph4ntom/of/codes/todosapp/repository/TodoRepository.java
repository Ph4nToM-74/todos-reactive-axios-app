package com.ph4ntom.of.codes.todosapp.repository;

import com.ph4ntom.of.codes.todosapp.model.Todo;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TodoRepository extends R2dbcRepository<Todo, Integer> {

  Flux<Todo> findByTitleContaining(final String title);

  Flux<Todo> findByDone(final boolean done);
}
