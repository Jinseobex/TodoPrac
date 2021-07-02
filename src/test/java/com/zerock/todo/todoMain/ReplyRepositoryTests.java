package com.zerock.todo.todoMain;

import com.zerock.todo.reply.entity.Reply;
import com.zerock.todo.reply.repository.ReplyRepository;
import com.zerock.todo.todoMain.entity.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@ActiveProfiles("dev")
public class ReplyRepositoryTests {

    @Autowired
    ReplyRepository replyRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 400).forEach(i -> {
            long tno = (int)(Math.random() * 300)+1;
            Todo todo = Todo.builder().tno(tno).build();
            Reply reply = Reply.builder()
                    .content("댓글"+i)
                    .replyWriter("댓글단사람"+i)
                    .todo(todo)
                    .build();
            replyRepository.save(reply);
        });
    }

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());

        Page<Reply> result = replyRepository.findAll(pageable);

        result.getContent().forEach(reply -> {
            log.info(reply);
        });

    }

    @Test
    public void testTodo() {
        Todo todo = Todo.builder()
                .tno(9L)
                .build();
        Pageable pageable = PageRequest.of(0, 10);
        replyRepository.getByTodo(todo, pageable).getContent().forEach(reply -> {
            log.info(reply);
        });
    }

}
