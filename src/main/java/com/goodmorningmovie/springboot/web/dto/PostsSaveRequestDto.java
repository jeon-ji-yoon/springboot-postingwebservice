package com.goodmorningmovie.springboot.web.dto;

import com.goodmorningmovie.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    //save하는 api를 꼭 테스트 해보고 싶음 ㅠㅠㅠㅠ!!!!!!
    private String title;
    private String content;
    private String author;


    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
