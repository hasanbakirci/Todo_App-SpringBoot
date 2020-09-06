package com.h94san.todo_app.DataAccess;

import com.h94san.todo_app.Entities.TodoList;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class TodoListDal implements ITodoListDal{
    private EntityManager entityManager;
    @Autowired
    public TodoListDal(EntityManager entityManager){this.entityManager = entityManager;}


    @Override
    @Transactional
    public List<TodoList> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<TodoList> todoLists = session.createQuery("from TodoList",TodoList.class).getResultList();
        return todoLists;
    }

    @Override
    public void add(TodoList todolist) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(todolist);

    }

    @Override
    public void update(TodoList todolist) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(todolist);
    }

    @Override
    public void delete(TodoList todolist) {
        Session session = entityManager.unwrap(Session.class);
        TodoList todoListDelete = session.get(TodoList.class, todolist.getId());
        session.delete(todoListDelete);
    }

    @Override
    public TodoList getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        TodoList todoList = session.get(TodoList.class, id);
        return todoList;
    }
}
