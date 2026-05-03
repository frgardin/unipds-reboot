package dev.felipegardin.security.service;

import java.util.List;

import dev.felipegardin.security.dto.UserDTO;

public interface IUserService {

    UserDTO createUser(UserDTO userDTO);

    List<UserDTO> listUsers();
}
