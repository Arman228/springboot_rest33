package com.Spring_Boot.spring.springboot_rest.dao;

import com.Spring_Boot.spring.springboot_rest.model.User;


import java.util.List;

public interface UserDao {

    void add(User user);

    User getById(int id);

    void delete(int id);


    void edit(User user);

    public List<User> getAllUsers();


}



