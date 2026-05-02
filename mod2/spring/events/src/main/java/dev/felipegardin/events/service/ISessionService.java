package dev.felipegardin.events.service;

import java.util.List;

import dev.felipegardin.events.model.Session;

public interface ISessionService {

    Session add(Session session);
    List<Session> getAll();
    Session getById(Integer id);
    Session update(Integer id, Session session);
    void delete(Integer id);
}
