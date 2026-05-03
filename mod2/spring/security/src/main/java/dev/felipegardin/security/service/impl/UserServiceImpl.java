package dev.felipegardin.security.service.impl;

import org.springframework.stereotype.Service;

import dev.felipegardin.security.dto.UserDTO;
import dev.felipegardin.security.mapper.UserMapper;
import dev.felipegardin.security.model.User;
import dev.felipegardin.security.repository.UserRepository;
import dev.felipegardin.security.service.IUserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        var newUser = userMapper.mapToNewUser(userDTO);
        User savedUser = userRepository.save(newUser);
        return userMapper.mapToUserDTO(savedUser);
    }
}
