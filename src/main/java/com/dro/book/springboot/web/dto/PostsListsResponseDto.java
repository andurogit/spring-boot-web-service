package com.dro.book.springboot.web.dto;

import com.dro.book.springboot.domain.posts.Posts;

import java.time.LocalDateTime;

public class PostsListsResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }

}
