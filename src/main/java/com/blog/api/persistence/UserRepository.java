package com.blog.api.persistence;

import com.blog.api.domain.UserDto;
import com.blog.api.domain.repository.UserDtoRepository;
import com.blog.api.persistence.crud.UserCrudRepository;
import com.blog.api.persistence.entity.User;
import com.blog.api.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserDtoRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserDto> getAll() {
        List<User> users = (List<User>) userCrudRepository.findAll();
        return mapper.toUserDtos(users);
    }

    @Override
    public UserDto save(UserDto userDto) {

        User user = mapper.toUser(userDto);
        return mapper.toUserDto(userCrudRepository.save(user));
    }
}
