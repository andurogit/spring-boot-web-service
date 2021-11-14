package com.dro.book.springboot.service.posts;

import com.dro.book.springboot.domain.posts.Posts;
import com.dro.book.springboot.domain.posts.PostsRepository;
import com.dro.book.springboot.web.dto.PostsListsResponseDto;
import com.dro.book.springboot.web.dto.PostsResponseDto;
import com.dro.book.springboot.web.dto.PostsSaveRequestDto;
import com.dro.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // final 로 선언 된 빈을 생성자를 이용하여 주입 의존성 변경 시 마다 생성자 코드가 변경 되는 처리 어노테이션 처리
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    /**
     * Jpa persistence ( 영속성 ) 으로 인해 sql 없이 update 가 가능하고 Entity 에 값만 변경해주면 데이터베이스에 반영이 된다.
     * 더티 체킹이란 개념이 있나보다.
     * 로직은 이런듯 하다. pk 로 넘겨 받은 id 값으로 repository 에서 검색을 해 찾은 후 값이 있다면  Entity 클래스에서  제목과 컨텐츠를 update 한다.
     * update 에서 사용할 값을 지정하기 위해서 Entity 클래스에서  값을 지정해서 비즈니스 로직을 짠걸까? 든금없어 보이긴 한다.
     * 그럼 update 해야할 값이 추가되거나하면 Entity 도 고쳐야하고 Update 메소드도 고쳐야 되는 걸까
     * @param id pk
     * @param requestDto
     * @return
     */
    @Transactional
    public long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional // readOnly 옵션이 안먹네...
    public List<PostsListsResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListsResponseDto::new) // .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id" + id));

        postsRepository.delete(posts);
    }
}
