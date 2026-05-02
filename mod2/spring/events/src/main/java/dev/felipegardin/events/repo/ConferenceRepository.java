package dev.felipegardin.events.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.felipegardin.events.model.Conference;

public interface ConferenceRepository extends JpaRepository<Conference, Integer> {
}
