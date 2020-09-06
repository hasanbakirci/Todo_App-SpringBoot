package com.h94san.todo_app.DataAccess;

import com.h94san.todo_app.Entities.TodoList;

import java.util.List;

public interface ITodoListDal {
    List<TodoList> getAll();
    void add(TodoList todolist);
    void update(TodoList todolist);
    void delete(TodoList todolist);
    TodoList getById(int id);
}
