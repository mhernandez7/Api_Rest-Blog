package com.blog.api.web.controller;

import com.blog.api.domain.UserDto;
import com.blog.api.domain.services.UserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDtoService userDtoService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll(){

        return new ResponseEntity<>(userDtoService.getAll(), HttpStatus.OK);

    }
    @PostMapping("/save")
    public ResponseEntity<UserDto> save (@RequestBody UserDto userDto){

        return new ResponseEntity<>(userDtoService.save(userDto ), HttpStatus.CREATED);
    }
}
