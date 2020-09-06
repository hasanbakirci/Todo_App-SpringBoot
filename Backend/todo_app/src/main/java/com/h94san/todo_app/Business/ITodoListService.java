package com.h94san.todo_app.Business;

import com.h94san.todo_app.Entities.TodoList;

import java.util.List;

public interface ITodoListService {
    List<TodoList> getAll();
    void add(TodoList todolist);
    void update(TodoList todolist);
    void delete(TodoList todolist);
    TodoList getById(int id);
}
