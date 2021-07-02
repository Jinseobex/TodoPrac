package com.zerock.todo.todoMain.controller;

import com.zerock.todo.todoMain.dto.todoDTO;
import com.zerock.todo.todoMain.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
@Log4j2
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/")
    public ResponseEntity<Long> register(@RequestBody todoDTO dto) {
        log.info("register........." + dto);
        Long tno = todoService.register(dto);
        return ResponseEntity.ok().body(tno);
    }

    @GetMapping("/{tno}")
    public ResponseEntity<todoDTO> read(@PathVariable Long tno) {
        todoDTO dto = todoService.read(tno);
                return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{tno}")
    public ResponseEntity<Long> delete(@PathVariable Long tno) {
        Long deletedTno = todoService.delete(tno);
        return ResponseEntity.ok().body(deletedTno);
    }

    @PutMapping("/{tno}")
    public ResponseEntity<todoDTO> modify(@PathVariable Long tno, @RequestBody todoDTO dto) {
        dto.setTno(tno);
        todoDTO resultDTO = todoService.modify(dto);
        return ResponseEntity.ok(resultDTO);
    }

}
