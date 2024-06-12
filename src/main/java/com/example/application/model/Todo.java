package com.example.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity 
public class Todo {

  @Getter
  @Setter
  @Id
  @GeneratedValue
  private Integer id;

  @Getter
  @Setter
  private String description;

  @Setter
  @Getter
  private boolean done = false;

  @Getter
  @Setter
  @NotBlank 
  private String task;

  public Todo() {}

  public Todo(String task) {
    this.task = task;
  }
}
