package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
    @Bean
    @Scope("prototype")
    public TaskList  taskList() {
        return new TaskList();
    }

    @Bean
    public Board board(TaskList toDo, TaskList inProgress, TaskList done) {
        return new Board(toDo, inProgress, done);
    }
}
