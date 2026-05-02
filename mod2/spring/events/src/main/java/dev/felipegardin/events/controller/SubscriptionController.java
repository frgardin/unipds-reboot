package dev.felipegardin.events.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.felipegardin.events.model.Session;
import dev.felipegardin.events.model.Subscription;
import dev.felipegardin.events.model.User;
import dev.felipegardin.events.service.ISubscriptionService;
import jakarta.annotation.PostConstruct;

@RestController
public class SubscriptionController {

    private final ISubscriptionService subscriptionService;

    public SubscriptionController(ISubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription subscription) throws URISyntaxException {
        Subscription createdSubscription = subscriptionService.addSubscription(subscription);
        return ResponseEntity.created(new URI("/subscription" + createdSubscription.getId())).body(createdSubscription);
    }

    @GetMapping("/subscriptions/user/{userId}")
    public ResponseEntity<List<Subscription>> getByUserId(@PathVariable(name = "userId") Integer id) {
        User user = new User();
        user.setId(id);
        return ResponseEntity.ok(subscriptionService.getAllByUser(user));
    }

    @GetMapping("/subscriptions/session/{sessionId}")
    public ResponseEntity<List<Subscription>> getBySessionId(@PathVariable(name = "sessionId") Integer id) {
        Session session = new Session();
        session.setId(id);
        return ResponseEntity.ok(subscriptionService.getAllBySession(session));
    }
}
