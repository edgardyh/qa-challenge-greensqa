package com.greensqa.repository;

import com.greensqa.model.User;

public interface IUserRepository {

    void save(User user);

    int countUsers();

    void deleteAll();
}