package dev.felipegardin.security.service;

import dev.felipegardin.security.dto.UserDTO;

public interface IUserService {

    UserDTO createUser(UserDTO userDTO);
}
