package dev.felipegardin.events.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import dev.felipegardin.events.model.Conference;
import dev.felipegardin.events.model.Session;
import dev.felipegardin.events.model.Subscription;
import dev.felipegardin.events.model.SubscriptionID;
import dev.felipegardin.events.model.User;
import dev.felipegardin.events.repo.ConferenceRepository;
import dev.felipegardin.events.repo.SessionRepository;
import dev.felipegardin.events.repo.SubscriptionRepository;
import dev.felipegardin.events.repo.UserRepository;

class SubscriptionControllerTest extends AbstractControllerTest {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    private User savedUser;
    private Session savedSession;

    @BeforeEach
    void setUp() {
        Conference c = new Conference();
        c.setName("JavaConf");
        c.setAddress("Rua A, 123");
        Conference savedConference = conferenceRepository.save(c);

        Session s = new Session();
        s.setTitle("Keynote");
        s.setStartDate(java.time.LocalDate.of(2026, 6, 1));
        s.setStartTime(java.time.LocalTime.of(9, 0));
        s.setConference(savedConference);
        savedSession = sessionRepository.save(s);

        User u = new User();
        u.setName("Felipe");
        u.setEmail("felipe@example.com");
        savedUser = userRepository.save(u);
    }

    // Sends only user and session ids to avoid Hibernate detached-entity issues.
    private String subscriptionJson() {
        return """
            {"id":{"user":{"id":%d},"session":{"id":%d}},"level":1}
            """.formatted(savedUser.getId(), savedSession.getId());
    }

    private Subscription savedSubscription() {
        SubscriptionID id = new SubscriptionID();
        id.setUser(savedUser);
        id.setSession(savedSession);
        Subscription sub = new Subscription();
        sub.setId(id);
        sub.setLevel(1);
        return subscriptionRepository.save(sub);
    }

    @Test
    void add_returnsCreated() throws Exception {
        mockMvc.perform(post("/subscriptions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(subscriptionJson()))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id.user.id").value(savedUser.getId()))
            .andExpect(jsonPath("$.id.session.id").value(savedSession.getId()))
            .andExpect(jsonPath("$.level").value(1));
    }

    @Test
    void getByUser_returnsOk() throws Exception {
        savedSubscription();

        mockMvc.perform(get("/subscriptions/user/" + savedUser.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id.user.id").value(savedUser.getId()))
            .andExpect(jsonPath("$[0].id.session.id").value(savedSession.getId()));
    }

    @Test
    void getBySession_returnsOk() throws Exception {
        savedSubscription();

        mockMvc.perform(get("/subscriptions/session/" + savedSession.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id.user.id").value(savedUser.getId()))
            .andExpect(jsonPath("$[0].id.session.id").value(savedSession.getId()));
    }
}
