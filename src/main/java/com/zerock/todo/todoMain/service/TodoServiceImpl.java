package com.zerock.todo.todoMain.service;

import com.zerock.todo.todoMain.dto.todoDTO;
import com.zerock.todo.todoMain.entity.Todo;
import com.zerock.todo.todoMain.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;


    @Override
    public Long register(todoDTO dto) {

        Todo todo = dtoToEntity(dto);

        Todo result = todoRepository.save(todo);

        return result.getTno();
    }

    @Override
    public todoDTO read(Long tno) {

        Optional<Todo> result = todoRepository.findById(tno);

        if(result.isPresent()) {
            Todo todo = result.get();
            return entityToDTO(todo);
        }

        return null;
    }

    @Override
    public Long delete(Long tno) {

        todoRepository.deleteById(tno);

        return tno;
    }

    @Override
    public todoDTO modify(todoDTO dto) {

        Optional<Todo> result = todoRepository.findById(dto.getTno());

        if(result.isPresent()) {
            Todo entity = result.get();
            entity.changeTitle(dto.getTitle());

            Todo saveResult = todoRepository.save(entity);

            return entityToDTO(saveResult);
        }

        return null;
    }
}
