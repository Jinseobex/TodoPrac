package com.zerock.todo.reply.entity;

import com.zerock.todo.common.BaseEntity;
import com.zerock.todo.todoMain.entity.Todo;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "todo_reply")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "todo")
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String content;

    private String replyWriter;

    private boolean del;

    @ManyToOne(fetch = FetchType.LAZY)
    private Todo todo;

}
