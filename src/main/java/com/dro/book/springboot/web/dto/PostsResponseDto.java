package com.dro.book.springboot.web.dto;

import com.dro.book.springboot.domain.posts.Posts;
import lombok.Getter;

/**
 * Entity 의 일부만 사용 생성자로 entity 받아서 사용
 */
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
