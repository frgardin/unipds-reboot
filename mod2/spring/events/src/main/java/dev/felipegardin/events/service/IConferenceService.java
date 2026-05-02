package dev.felipegardin.events.service;

import java.util.List;

import dev.felipegardin.events.model.Conference;

public interface IConferenceService {

    Conference add(Conference conference);
    List<Conference> getAll();
    Conference getById(Integer id);
    Conference update(Integer id, Conference conference);
    void delete(Integer id);
}
