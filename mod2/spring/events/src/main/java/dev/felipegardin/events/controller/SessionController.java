package dev.felipegardin.events.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.felipegardin.events.model.Session;
import dev.felipegardin.events.service.ISessionService;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private final ISessionService sessionService;

    public SessionController(ISessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public ResponseEntity<Session> add(@RequestBody Session session) throws URISyntaxException {
        Session created = sessionService.add(session);
        return ResponseEntity.created(new URI("/sessions/" + created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Session>> getAll() {
        return ResponseEntity.ok(sessionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(sessionService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Session> update(@PathVariable Integer id, @RequestBody Session session) {
        return ResponseEntity.ok(sessionService.update(id, session));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        sessionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
