package com.ph4ntom.of.codes.todosapp.service;

import com.ph4ntom.of.codes.todosapp.model.Todo;
import com.ph4ntom.of.codes.todosapp.repository.TodoRepository;
import java.util.Optional;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodoService {

  private final TodoRepository todoRepository;

  public TodoService(final TodoRepository todoRepository) {

    this.todoRepository = todoRepository;
  }

  public Flux<Todo> findAllTodos() {

    return todoRepository.findAll();
  }

  public Flux<Todo> findTodosContainingTitle(final String title) {

    return todoRepository.findByTitleContaining(title);
  }

  public Mono<Todo> findSpecificTodo(final int id) {

    return todoRepository.findById(id);
  }

  public Flux<Todo> findDoneTodos(final boolean done) {

    return todoRepository.findByDone(done);
  }

  public Mono<Todo> saveNewTodo(final Todo todo) {

    return todoRepository.save(todo);
  }

  public Mono<Void> removeSpecificTodo(int id) {
    return todoRepository.deleteById(id);
  }

  public Mono<Void> removeAllTodos() {

    return todoRepository.deleteAll();
  }

  public Mono<Todo> editSpecificTodo(final int id, final Todo todo) {

    return todoRepository.findById(id)
                         .map(Optional::of)
                         .defaultIfEmpty(Optional.empty())
                         .flatMap(optionalTutorial -> this.setIfPresent
                                 (id, todo, optionalTutorial));
  }

  private Mono<Todo> setIfPresent(final int id, final Todo todo,
                     final Optional<Todo> optionalTutorial) {

    if (optionalTutorial.isPresent()) {

      todo.setId(id);

      return todoRepository.save(todo);
    }

    return Mono.empty();
  }
}
