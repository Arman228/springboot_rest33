package com.Spring_Boot.spring.springboot_rest.dao;

import com.Spring_Boot.spring.springboot_rest.model.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager em;


    @Override
    public void add(User user) {
        em.persist(user);

    }

    @Override
    public User getById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void delete(int id) {

        User user = em.find(User.class, id);
        if (em.find(User.class, id) != null) {
            em.remove(user);
        }
    }

    @Override
    public void edit(User user) {
        em.merge(user);


    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from  User u", User.class).getResultList();
    }


}


