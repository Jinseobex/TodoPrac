package com.zerock.todo.reply.repository;

import com.zerock.todo.reply.entity.Reply;
import com.zerock.todo.todoMain.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    Page<Reply> getByTodo(Todo todo, Pageable pageable);
}
