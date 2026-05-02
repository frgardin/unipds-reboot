package dev.felipegardin.events.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import dev.felipegardin.events.model.Conference;
import dev.felipegardin.events.repo.ConferenceRepository;

class ConferenceControllerTest extends AbstractControllerTest {

    @Autowired
    private ConferenceRepository conferenceRepository;

    private Conference conference() {
        Conference c = new Conference();
        c.setName("JavaConf");
        c.setAddress("Rua A, 123");
        return c;
    }

    @Test
    void add_returnsCreated() throws Exception {
        mockMvc.perform(post("/conferences")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(conference())))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").isNumber())
            .andExpect(jsonPath("$.name").value("JavaConf"))
            .andExpect(jsonPath("$.address").value("Rua A, 123"));
    }

    @Test
    void getAll_returnsOk() throws Exception {
        conferenceRepository.save(conference());

        mockMvc.perform(get("/conferences"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("JavaConf"));
    }

    @Test
    void getById_returnsOk() throws Exception {
        Conference saved = conferenceRepository.save(conference());

        mockMvc.perform(get("/conferences/" + saved.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("JavaConf"));
    }

    @Test
    void getById_notFound_returns404() throws Exception {
        mockMvc.perform(get("/conferences/999"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("Conference not found"));
    }

    @Test
    void update_returnsOk() throws Exception {
        Conference saved = conferenceRepository.save(conference());

        Conference updated = new Conference();
        updated.setName("JavaConf Updated");
        updated.setAddress("Rua B, 456");

        mockMvc.perform(put("/conferences/" + saved.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updated)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("JavaConf Updated"))
            .andExpect(jsonPath("$.address").value("Rua B, 456"));
    }

    @Test
    void update_notFound_returns404() throws Exception {
        mockMvc.perform(put("/conferences/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(conference())))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("Conference not found"));
    }

    @Test
    void delete_returnsNoContent() throws Exception {
        Conference saved = conferenceRepository.save(conference());

        mockMvc.perform(delete("/conferences/" + saved.getId()))
            .andExpect(status().isNoContent());
    }
}
