package dev.felipegardin.events.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.felipegardin.events.model.Session;
import dev.felipegardin.events.model.Subscription;
import dev.felipegardin.events.model.User;
import dev.felipegardin.events.repo.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService{

    private final SubscriptionRepository repository;

    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscription addSubscription(Subscription subscription) {
        subscription.setCreatedAt(null);
        return repository.save(subscription);
    }

    @Override
    public List<Subscription> getAllByUser(User user) {
        return repository.findByIdUser(user);
    }

    @Override
    public List<Subscription> getAllBySession(Session session) {
        return repository.findByIdSession(session);
    }
}
