package dev.felipegardin.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import dev.felipegardin.security.dto.UserDTO;
import dev.felipegardin.security.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(ignore = true, target = "id")
    User mapToNewUser(UserDTO userDTO);

    UserDTO mapToUserDTO(User userDTO);    
}
