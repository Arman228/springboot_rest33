package com.Spring_Boot.spring.springboot_rest.dao;

import com.Spring_Boot.spring.springboot_rest.model.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entity;


    @Override
    public void add(User user) {
        entity.persist(user);

    }

    @Override
    public User getById(int id) {
        return entity.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        User user = entity.find(User.class, id);
        entity.remove(user);

    }

    @Override
    public void edit( User user) {
        entity.merge(user);


    }

    @Override
    public List<User> getAllUsers() {
        return entity.createQuery("select u from  User u", User.class).getResultList();
    }


}


