package com.example.Prueba.service.impl;

import com.example.Prueba.dto.UserDto;
import com.example.Prueba.dto.UserResponse;

import com.example.Prueba.entity.User;
import com.example.Prueba.repository.UsersRepository;
import com.example.Prueba.service.UserService;
import com.example.Prueba.utils.EncriptarDesencriptar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    @Override
    public UserDto save(UserDto userDto) {
        try {
            String passEcrip = EncriptarDesencriptar.Encriptar(userDto.getPassword());

            User user = modelMapper.map(userDto, User.class);
            user.setPassword(passEcrip);
            usersRepository.save(user);
            return modelMapper.map(user, UserDto.class);
        }catch (Exception e){
            return null;

        }
    }

    @Override
    public ArrayList<User> listAll() {
        return (ArrayList<User>) usersRepository.findAll();
    }

    @Override
    public Optional<UserDto> update(UserDto userDto,Long id) {
        User user= usersRepository.findById(id).get();
        user.setNameUser(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setAddres(userDto.getAddres());
        user.setIdentification(userDto.getIdentification());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setTotalValue(user.getTotalValue());

        return Optional.ofNullable(modelMapper.map(user, UserDto.class));

    }

}
