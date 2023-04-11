package com.blog.api.persistence.mapper;

import com.blog.api.domain.PostDto;
import com.blog.api.persistence.entity.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, UserMapper.class})
public interface PostMapper {

    @Mappings({
            @Mapping(source = "category", target = "categoryDto"),
            @Mapping(source = "user", target = "userDto")
    })

    PostDto toPostDto (Post post);
    List<PostDto> toPostDtos (List<Post> posts);
    @InheritInverseConfiguration
    Post toPost(PostDto postDto);

}
