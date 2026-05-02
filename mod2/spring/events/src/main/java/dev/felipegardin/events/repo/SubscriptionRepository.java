package dev.felipegardin.events.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.felipegardin.events.model.Session;
import dev.felipegardin.events.model.Subscription;
import dev.felipegardin.events.model.SubscriptionID;
import dev.felipegardin.events.model.User;

public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionID> {

    List<Subscription> findByIdUser(User user);

    List<Subscription> findByIdSession(Session session);
}
