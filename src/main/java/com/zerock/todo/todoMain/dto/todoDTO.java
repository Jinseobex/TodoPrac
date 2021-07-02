package com.zerock.todo.todoMain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class todoDTO {

    private Long tno;

    private String title;

    private String content;

    private String writer;

    private boolean del;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

}
