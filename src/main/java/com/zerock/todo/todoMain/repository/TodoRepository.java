package com.zerock.todo.todoMain.repository;

import com.zerock.todo.todoMain.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
