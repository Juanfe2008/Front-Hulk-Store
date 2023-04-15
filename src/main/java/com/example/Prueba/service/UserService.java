package com.example.Prueba.service;

import com.example.Prueba.dto.UserDto;
import com.example.Prueba.entity.User;
import java.util.ArrayList;
import java.util.Optional;

public interface UserService {
    UserDto save(UserDto userDto);
    ArrayList<User> listAll();
    Optional<UserDto> update(UserDto userDto, Long id);
}
