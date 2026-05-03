package dev.felipegardin.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.felipegardin.security.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
