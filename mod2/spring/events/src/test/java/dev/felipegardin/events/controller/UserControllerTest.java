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

import dev.felipegardin.events.model.User;
import dev.felipegardin.events.repo.UserRepository;

class UserControllerTest extends AbstractControllerTest {

    @Autowired
    private UserRepository userRepository;

    private User user() {
        User u = new User();
        u.setName("Felipe");
        u.setEmail("felipe@example.com");
        return u;
    }

    @Test
    void add_returnsCreated() throws Exception {
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user())))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").isNumber())
            .andExpect(jsonPath("$.name").value("Felipe"))
            .andExpect(jsonPath("$.email").value("felipe@example.com"));
    }

    @Test
    void getAll_returnsOk() throws Exception {
        userRepository.save(user());

        mockMvc.perform(get("/users"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("Felipe"));
    }

    @Test
    void getById_returnsOk() throws Exception {
        User saved = userRepository.save(user());

        mockMvc.perform(get("/users/" + saved.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Felipe"))
            .andExpect(jsonPath("$.email").value("felipe@example.com"));
    }

    @Test
    void getById_notFound_returns404() throws Exception {
        mockMvc.perform(get("/users/999"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("User not found"));
    }

    @Test
    void update_returnsOk() throws Exception {
        User saved = userRepository.save(user());

        User updated = new User();
        updated.setName("Felipe Updated");
        updated.setEmail("updated@example.com");

        mockMvc.perform(put("/users/" + saved.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updated)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Felipe Updated"))
            .andExpect(jsonPath("$.email").value("updated@example.com"));
    }

    @Test
    void update_notFound_returns404() throws Exception {
        mockMvc.perform(put("/users/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user())))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("User not found"));
    }

    @Test
    void delete_returnsNoContent() throws Exception {
        User saved = userRepository.save(user());

        mockMvc.perform(delete("/users/" + saved.getId()))
            .andExpect(status().isNoContent());
    }
}
