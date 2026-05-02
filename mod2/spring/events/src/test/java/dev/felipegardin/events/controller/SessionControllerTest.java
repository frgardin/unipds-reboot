package dev.felipegardin.events.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import dev.felipegardin.events.model.Conference;
import dev.felipegardin.events.model.Session;
import dev.felipegardin.events.repo.ConferenceRepository;
import dev.felipegardin.events.repo.SessionRepository;

class SessionControllerTest extends AbstractControllerTest {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private SessionRepository sessionRepository;

    private Conference savedConference;

    @BeforeEach
    void setUp() {
        Conference c = new Conference();
        c.setName("JavaConf");
        c.setAddress("Rua A, 123");
        savedConference = conferenceRepository.save(c);
    }

    // Sends only the conference id to avoid Hibernate detached-entity issues.
    private String sessionJson(String title) {
        return """
            {"title":"%s","startDate":"2026-06-01","startTime":"09:00:00","conference":{"id":%d}}
            """.formatted(title, savedConference.getId());
    }

    @Test
    void add_returnsCreated() throws Exception {
        mockMvc.perform(post("/sessions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sessionJson("Keynote")))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").isNumber())
            .andExpect(jsonPath("$.title").value("Keynote"));
    }

    @Test
    void getAll_returnsOk() throws Exception {
        Session s = new Session();
        s.setTitle("Keynote");
        s.setStartDate(java.time.LocalDate.of(2026, 6, 1));
        s.setStartTime(java.time.LocalTime.of(9, 0));
        s.setConference(savedConference);
        sessionRepository.save(s);

        mockMvc.perform(get("/sessions"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].title").value("Keynote"));
    }

    @Test
    void getById_returnsOk() throws Exception {
        Session s = new Session();
        s.setTitle("Keynote");
        s.setStartDate(java.time.LocalDate.of(2026, 6, 1));
        s.setStartTime(java.time.LocalTime.of(9, 0));
        s.setConference(savedConference);
        Session saved = sessionRepository.save(s);

        mockMvc.perform(get("/sessions/" + saved.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("Keynote"));
    }

    @Test
    void getById_notFound_returns404() throws Exception {
        mockMvc.perform(get("/sessions/999"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("Session not found"));
    }

    @Test
    void update_returnsOk() throws Exception {
        Session s = new Session();
        s.setTitle("Keynote");
        s.setStartDate(java.time.LocalDate.of(2026, 6, 1));
        s.setStartTime(java.time.LocalTime.of(9, 0));
        s.setConference(savedConference);
        Session saved = sessionRepository.save(s);

        mockMvc.perform(put("/sessions/" + saved.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(sessionJson("Keynote Updated")))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("Keynote Updated"));
    }

    @Test
    void update_notFound_returns404() throws Exception {
        mockMvc.perform(put("/sessions/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sessionJson("Keynote")))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("Session not found"));
    }

    @Test
    void delete_returnsNoContent() throws Exception {
        Session s = new Session();
        s.setTitle("Keynote");
        s.setStartDate(java.time.LocalDate.of(2026, 6, 1));
        s.setStartTime(java.time.LocalTime.of(9, 0));
        s.setConference(savedConference);
        Session saved = sessionRepository.save(s);

        mockMvc.perform(delete("/sessions/" + saved.getId()))
            .andExpect(status().isNoContent());
    }
}
