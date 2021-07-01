package com.h94san.todo_app.controller;

import com.h94san.todo_app.model.Todo;
import com.h94san.todo_app.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/")
    public ResponseEntity<Todo> save(@RequestBody Todo todo){
        return ResponseEntity.ok(this.todoService.save(todo));
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> findAll(){
        return ResponseEntity.ok(this.todoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable int id,
                                           @RequestBody Todo todo ){
        return ResponseEntity.ok(todoService.updateTodo(id, todo));
    }
}
