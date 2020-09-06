package com.h94san.todo_app.Business;

import com.h94san.todo_app.DataAccess.ITodoListDal;
import com.h94san.todo_app.Entities.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoListManager implements ITodoListService {
    private ITodoListDal todoListDal;
    @Autowired
    public TodoListManager(ITodoListDal todoListDal){this.todoListDal = todoListDal;}

    @Override
    @Transactional
    public List<TodoList> getAll() {
        return this.todoListDal.getAll();
    }

    @Override
    @Transactional
    public void add(TodoList todolist) {
        this.todoListDal.add(todolist);
    }

    @Override
    @Transactional
    public void update(TodoList todolist) {
        this.todoListDal.update(todolist);
    }

    @Override
    @Transactional
    public void delete(TodoList todolist) {
        this.todoListDal.delete(todolist);
    }

    @Override
    @Transactional
    public TodoList getById(int id) {
        return this.todoListDal.getById(id);
    }
}
