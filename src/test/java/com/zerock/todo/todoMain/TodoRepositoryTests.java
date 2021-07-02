package com.zerock.todo.todoMain;

import com.zerock.todo.todoMain.entity.Todo;
import com.zerock.todo.todoMain.repository.TodoRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@ActiveProfiles("dev")
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testInsert() {

        IntStream.rangeClosed(1, 300).forEach(i -> {
            Todo todo = Todo.builder()
                    .title("제목"+i)
                    .content("내용"+i)
                    .writer("글쓴이"+i)
                    .build();
            todoRepository.save(todo);
            log.info(todo);
        });

    }

    @Test
    public void testSelect() {
        Optional<Todo> result = todoRepository.findById(2L);
        result.ifPresent(todo -> log.info(todo));
    }

    @Test
    public void testUpdate() {
        Optional<Todo> result = todoRepository.findById(2L);
        result.ifPresent(todo -> {
            todo.changeTitle("2번 게시물 수정");
            todoRepository.save(todo);
        });
    }

    @Test
    public void testDelete() {
        todoRepository.deleteById(3L);
    }

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0, 15, Sort.by("tno").descending());
        Page<Todo> result = todoRepository.findAll(pageable);
        log.info(result);
        result.getContent().forEach(todo -> {
            log.info(todo);
        });

    }

}
