package dev.felipegardin.events.service;

import java.util.List;

import dev.felipegardin.events.model.Session;
import dev.felipegardin.events.model.Subscription;
import dev.felipegardin.events.model.User;

public interface ISubscriptionService {

    Subscription addSubscription(Subscription subscription);
    List<Subscription> getAllByUser(User user);
    List<Subscription> getAllBySession(Session session);
}
