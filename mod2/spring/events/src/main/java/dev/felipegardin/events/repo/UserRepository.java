package dev.felipegardin.events.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.felipegardin.events.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
