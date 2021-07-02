package com.zerock.todo.todoMain.service;

import com.zerock.todo.todoMain.dto.todoDTO;
import com.zerock.todo.todoMain.entity.Todo;

public interface TodoService {

    default todoDTO entityToDTO(Todo entity) {
        return todoDTO.builder()
                .tno(entity.getTno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
    }

    default Todo dtoToEntity(todoDTO dto) {
        return Todo.builder()
                .tno(dto.getTno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }

    Long register(todoDTO dto);

    todoDTO read(Long tno);

    Long delete(Long tno);

    todoDTO modify(todoDTO dto);
}
