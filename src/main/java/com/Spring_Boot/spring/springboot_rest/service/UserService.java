package com.Spring_Boot.spring.springboot_rest.service;



import com.Spring_Boot.spring.springboot_rest.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    Object getById(int id);

    void delete(int id);

    void edit( User user);

    public List<User> getAllUsers();
}
