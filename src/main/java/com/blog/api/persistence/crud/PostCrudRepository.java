package com.blog.api.persistence.crud;

import com.blog.api.persistence.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostCrudRepository extends CrudRepository<Post, Integer> {

    List<Post> findByIdCategory(int idCategory);
    List<Post> findByIdUser(int idUser);
}
