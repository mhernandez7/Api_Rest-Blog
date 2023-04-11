package com.blog.api.persistence.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idPost;

    @Column(name = "titulo")
    private String title;

    @Column(name = "fecha_publicacion")
    private LocalDateTime publicTime;

    @Column(name = "contenido")
    private String description;

    @Column(name = "estatus")
    private String state;

    @Column(name ="usuari_id")
    private Integer idUser;

    @Column(name = "categoria_id")
    private Integer idCategory;

    @ManyToOne
    @JoinColumn(name = "categoria_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name ="usuari_id", insertable = false, updatable = false)
    private User user;
    public Integer getIdPost() {
        return idPost;
    }

    public void setIdPost(Integer idPost) {
        this.idPost = idPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(LocalDateTime publicTime) {
        this.publicTime = publicTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
