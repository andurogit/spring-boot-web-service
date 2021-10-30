package com.dro.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository 확장 구현
 * 인자값1 : Entity Class
 * 인자값2 : PK type
 */
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
