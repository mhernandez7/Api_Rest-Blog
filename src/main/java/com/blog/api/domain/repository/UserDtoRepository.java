package com.blog.api.domain.repository;

import com.blog.api.domain.UserDto;

import java.util.List;

public interface UserDtoRepository {

    List<UserDto> getAll();
    UserDto save (UserDto userDto);
}
