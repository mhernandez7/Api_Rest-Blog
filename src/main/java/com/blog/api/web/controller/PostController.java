package com.blog.api.web.controller;

import com.blog.api.domain.PostDto;
import com.blog.api.domain.services.PostService;
import com.blog.api.persistence.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private  PostService postService;

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> getAll(){
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/category/{idCategory}")
    public ResponseEntity<List<PostDto>> getByIdCategory(@PathVariable("idCategory") int idCategory){

        return postService.getByIdCategory(idCategory)
                .map(postDtos -> new ResponseEntity<>(postDtos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<PostDto>> getByIdUser(@PathVariable("idUser") int idUser){
        return postService.getByIdUser(idUser)
                .map(postDtos -> new ResponseEntity<>(postDtos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{idPost}")
    public ResponseEntity<PostDto> getByIdPost(@PathVariable("idPost") int idPost){

        return postService.getByIdPost(idPost)
                .map(postDtos -> new ResponseEntity<>(postDtos, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<PostDto> save (@RequestBody PostDto postDto){

        return new ResponseEntity<>(postService.save(postDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{idPost}")
    public ResponseEntity<PostDto> delete(@PathVariable("idPost") int idPost){

        if(postService.delete(idPost)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
