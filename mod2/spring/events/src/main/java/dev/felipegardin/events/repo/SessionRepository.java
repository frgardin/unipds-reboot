package dev.felipegardin.events.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.felipegardin.events.model.Session;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
