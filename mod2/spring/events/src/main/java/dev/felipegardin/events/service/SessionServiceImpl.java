package dev.felipegardin.events.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.felipegardin.events.exception.NotFoundException;
import dev.felipegardin.events.model.Session;
import dev.felipegardin.events.repo.SessionRepository;

@Service
public class SessionServiceImpl implements ISessionService {

    private final SessionRepository repository;

    public SessionServiceImpl(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Session add(Session session) {
        return repository.save(session);
    }

    @Override
    public List<Session> getAll() {
        return repository.findAll();
    }

    @Override
    public Session getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Session not found"));
    }

    @Override
    public Session update(Integer id, Session session) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Session not found"));
        session.setId(id);
        return repository.save(session);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
