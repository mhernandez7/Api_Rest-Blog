package com.blog.api.persistence.mapper;

import com.blog.api.domain.UserDto;
import com.blog.api.persistence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserDto toUserDto (User user);
    List<UserDto> toUserDtos (List<User> users);
    @InheritInverseConfiguration
    @Mapping(target = "postsU", ignore = true)

    User toUser (UserDto userDto);


}
