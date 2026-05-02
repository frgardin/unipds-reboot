package dev.felipegardin.events.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.felipegardin.events.model.Subscription;
import dev.felipegardin.events.model.SubscriptionID;

public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionID> {
}
