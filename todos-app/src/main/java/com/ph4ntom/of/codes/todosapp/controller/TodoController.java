package com.ph4ntom.of.codes.todosapp.controller;

import com.ph4ntom.of.codes.todosapp.model.Todo;
import com.ph4ntom.of.codes.todosapp.service.TodoService;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/reactive")
public class TodoController {

  private final TodoService todoService;

  public TodoController(final TodoService todoService) {

    this.todoService = todoService;
  }

  @GetMapping("/todos")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Todo> readAllTodos(final @RequestParam
                    (required = false) String title) {

    if (Objects.isNull(title)) return todoService.findAllTodos();
    else return todoService.findTodosContainingTitle(title);
  }

  @GetMapping("/todos/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Todo> readSpecificTodo(final @PathVariable("id") int id) {

    return todoService.findSpecificTodo(id);
  }

  @GetMapping("/todos/done")
  @ResponseStatus(HttpStatus.OK)
  public Flux<Todo> readDoneTodos() {

    return todoService.findDoneTodos(true);
  }

  @PostMapping("/todos")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Todo> createNewTodo(final @RequestBody Todo todo) {

    return todoService.saveNewTodo(new Todo(todo.getTitle(),
                       todo.getDescription(), false));
  }

  @PutMapping("/todos/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Todo> updateSpecificTodo(final @PathVariable("id") int id,
                                       final @RequestBody Todo todo) {

    return todoService.editSpecificTodo(id, todo);
  }

  @DeleteMapping("/todos/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteSpecificTodo(final @PathVariable("id") int id) {

    return todoService.removeSpecificTodo(id);
  }

  @DeleteMapping("/todos")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteAllTodos() {

    return todoService.removeAllTodos();
  }
}
