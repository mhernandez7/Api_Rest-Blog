package com.blog.api.persistence;

import com.blog.api.domain.PostDto;
import com.blog.api.domain.repository.PostDtoRepository;
import com.blog.api.persistence.crud.PostCrudRepository;
import com.blog.api.persistence.entity.Post;
import com.blog.api.persistence.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository implements PostDtoRepository {

    @Autowired
    private PostCrudRepository postCrudRepository;
    @Autowired
    private PostMapper mapper;

    @Override
    public List<PostDto> getAll() {

        List<Post> posts = (List<Post>) postCrudRepository.findAll();
        return mapper.toPostDtos(posts);
    }

    @Override
    public Optional<List<PostDto>> getByIdCategory(int idCategory) {

        List<Post> posts =(List<Post>) postCrudRepository.findByIdCategory(idCategory);
        return Optional.of(mapper.toPostDtos(posts));
    }

    @Override
    public Optional<List<PostDto>> getByIdUser(int idUser) {
        List<Post> posts =( List<Post>) postCrudRepository.findByIdUser(idUser);
        return Optional.of(mapper.toPostDtos(posts));
    }

    @Override
    public Optional<PostDto> getByIdPost(int idPost) {
        return postCrudRepository.findById(idPost).map(post -> mapper.toPostDto(post));
    }

    @Override
    public PostDto save(PostDto postDto) {

        Post post = mapper.toPost(postDto);
        return mapper.toPostDto(postCrudRepository.save(post));
    }

    @Override
    public void delete(int idPost) {
        postCrudRepository.deleteById(idPost);
    }
}
