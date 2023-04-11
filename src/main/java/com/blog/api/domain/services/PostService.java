package com.blog.api.domain.services;

import com.blog.api.domain.PostDto;
import com.blog.api.domain.repository.PostDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostDtoRepository postDtoRepository;

    public List<PostDto> getAll(){

        return postDtoRepository.getAll();

    }
    public Optional<List<PostDto>> getByIdCategory(int idCategory){

        return postDtoRepository.getByIdCategory(idCategory);

    }
    public Optional<List<PostDto>> getByIdUser(int idUser){
        return  postDtoRepository.getByIdUser(idUser);
    }
    public Optional<PostDto> getByIdPost(int idPost){
        return postDtoRepository.getByIdPost(idPost);
    }
    public PostDto save (PostDto postDto){
        return postDtoRepository.save(postDto);
    }
    public Boolean delete (int idPost){

        return getByIdPost(idPost).map(postDto ->
        {postDtoRepository.delete(idPost);
            return true;
        }).orElse(false);
    }
}
