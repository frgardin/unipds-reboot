package dev.felipegardin.events.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.felipegardin.events.exception.NotFoundException;
import dev.felipegardin.events.model.User;
import dev.felipegardin.events.repo.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User update(Integer id, User user) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        user.setId(id);
        return repository.save(user);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
