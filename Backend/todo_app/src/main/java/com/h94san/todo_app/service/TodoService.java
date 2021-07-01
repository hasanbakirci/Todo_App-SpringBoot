package com.h94san.todo_app.service;
import com.h94san.todo_app.model.Todo;
import com.h94san.todo_app.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService{
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo save(Todo todo){
        return todoRepository.save(todo);
    }

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    private Todo findById(int id){
        return todoRepository.getById(id);
    }

    public void deleteTodo(int id){
        todoRepository.deleteById(id);
    }

    public Todo updateTodo(int id,Todo todo){
        Todo myTodo = findById(id);
        myTodo.setTitle(todo.getTitle());
        myTodo.setMessage(todo.getMessage());
        myTodo.setCreatedDate(todo.getCreatedDate());
        return save(myTodo);
    }
}
