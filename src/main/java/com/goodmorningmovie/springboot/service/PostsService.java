package com.goodmorningmovie.springboot.service;

import com.goodmorningmovie.springboot.domain.posts.Posts;
import com.goodmorningmovie.springboot.domain.posts.PostsRepository;
import com.goodmorningmovie.springboot.web.dto.PostsListResponseDto;
import com.goodmorningmovie.springboot.web.dto.PostsResponseDto;
import com.goodmorningmovie.springboot.web.dto.PostsSaveRequestDto;
import com.goodmorningmovie.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }


    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        //postsrepository(도메인 영역)에서 정의한 메소드를 가져옴
        return postsRepository
                .findAllDesc()
                .stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글 없음"));

        postsRepository.delete(posts);
    }
}
