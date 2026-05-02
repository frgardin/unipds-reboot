package dev.felipegardin.events.service;

import java.util.List;

import dev.felipegardin.events.model.User;

public interface IUserService {

    User add(User user);
    List<User> getAll();
    User getById(Integer id);
    User update(Integer id, User user);
    void delete(Integer id);
}
