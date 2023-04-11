package com.blog.api.domain.services;

import com.blog.api.domain.UserDto;
import com.blog.api.domain.repository.UserDtoRepository;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDtoService {
    @Autowired
    private UserDtoRepository userDtoRepository;

    public List<UserDto> getAll(){
        return userDtoRepository.getAll();
    }

    public UserDto save (UserDto userDto){

        return userDtoRepository.save(userDto);
    }
}
