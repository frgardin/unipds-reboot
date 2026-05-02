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

import dev.felipegardin.events.model.Conference;
import dev.felipegardin.events.service.IConferenceService;

@RestController
@RequestMapping("/conferences")
public class ConferenceController {

    private final IConferenceService conferenceService;

    public ConferenceController(IConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @PostMapping
    public ResponseEntity<Conference> add(@RequestBody Conference conference) throws URISyntaxException {
        Conference created = conferenceService.add(conference);
        return ResponseEntity.created(new URI("/conferences/" + created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Conference>> getAll() {
        return ResponseEntity.ok(conferenceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conference> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(conferenceService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conference> update(@PathVariable Integer id, @RequestBody Conference conference) {
        return ResponseEntity.ok(conferenceService.update(id, conference));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        conferenceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
