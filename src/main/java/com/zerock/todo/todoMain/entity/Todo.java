package com.zerock.todo.todoMain.entity;

import com.zerock.todo.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "todo_prac")
@ToString
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;

    private String title;

    private String content;

    private String writer;

    private boolean del;

    public void changeTitle(String title) {
        this.title = title;
    }

}
