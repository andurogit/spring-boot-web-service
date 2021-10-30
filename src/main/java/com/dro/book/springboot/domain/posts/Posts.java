package com.dro.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity 클래스에는 Setter 미 권장
 * DB 저장 시 builder 패턴 사용
 * ex) Posts.builder()
 *        .id()
 *        .title("test")
 *        ...
 */
@Getter
@NoArgsConstructor // 기본생성자 추가 public Posts() {}
@Entity // 테이블과 링크될 클래스 명시 Id 컬럼 필수
public class Posts {

    /**
     * PK 는 Long type 지정 권장
     * mysql 은 bigint 타입으로 지정 됨
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key 생성 규칙 지정 IDENTITY 는 auto increase
    private Long id;

    @Column(length = 500, nullable = false) // Column 미 지정해도 기본설정 되지만 추가 옵션처리를 위해 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
