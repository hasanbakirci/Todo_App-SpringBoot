package com.h94san.todo_app.RestApi;

import com.h94san.todo_app.Business.ITodoListService;
import com.h94san.todo_app.Entities.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoListController {
    private ITodoListService todoListService;

    @Autowired
    public TodoListController(ITodoListService todoListService){this.todoListService = todoListService;}

    @GetMapping("/todolists")
    public List<TodoList> get(){return todoListService.getAll();}

    @PostMapping("/add")
    public void add(@RequestBody TodoList todoList){todoListService.add(todoList);}

    @PostMapping("/update")
    public void update(@RequestBody TodoList todoList){todoListService.update(todoList);}

    @PostMapping("/delete")
    public void delete(@RequestBody TodoList todoList){todoListService.delete(todoList);}

    @GetMapping("/todolists/{id}")
    public TodoList getById(@PathVariable int id){return todoListService.getById(id);}
}
