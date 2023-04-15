package com.example.Prueba.controller;

import com.example.Prueba.dto.UserDto;
import com.example.Prueba.entity.User;
import com.example.Prueba.service.impl.UserImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserImpl userImpl;
    @PostMapping(value = "/save")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        return new ResponseEntity<UserDto>(userImpl.save(userDto), HttpStatus.CREATED);
    }
    @GetMapping(value = "/list")
    public ArrayList<User> listAll(){
        return this.userImpl.listAll();
    }
    @PutMapping(path = "/{id}")
    public Optional<UserDto> update(@RequestBody UserDto userDto, Long id){
        return this.userImpl.update(userDto, id);
    }

}
