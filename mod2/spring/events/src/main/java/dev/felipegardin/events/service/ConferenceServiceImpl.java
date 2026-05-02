package dev.felipegardin.events.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.felipegardin.events.exception.NotFoundException;
import dev.felipegardin.events.model.Conference;
import dev.felipegardin.events.repo.ConferenceRepository;

@Service
public class ConferenceServiceImpl implements IConferenceService {

    private final ConferenceRepository repository;

    public ConferenceServiceImpl(ConferenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Conference add(Conference conference) {
        return repository.save(conference);
    }

    @Override
    public List<Conference> getAll() {
        return repository.findAll();
    }

    @Override
    public Conference getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Conference not found"));
    }

    @Override
    public Conference update(Integer id, Conference conference) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Conference not found"));
        conference.setId(id);
        return repository.save(conference);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
