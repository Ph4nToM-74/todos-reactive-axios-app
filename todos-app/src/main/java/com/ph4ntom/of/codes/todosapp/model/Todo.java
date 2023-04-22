package com.ph4ntom.of.codes.todosapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Todo {

  @Id private int id;

  private String title;
  private String description;

  private boolean done;

  public Todo(final String title,
              final String description,
              final boolean done) {

    this.title = title;
    this.description = description;
    this.done = done;
  }
}
