package com.blog.api.domain.repository;

import com.blog.api.domain.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostDtoRepository {

     List<PostDto> getAll();
     Optional<List<PostDto>>getByIdCategory(int idCategory );
     Optional<List<PostDto>>getByIdUser(int idUser);
     Optional<PostDto>getByIdPost(int idPost);
     PostDto save (PostDto postDto);
     void delete (int idPost);

}
