package com.goodmorningmovie.springboot.domain.posts;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


//@RunWith(SpringRunner.class) junt5부터는 @SpringBootTest에 포함됨
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach //junit5부터는 aftereach로 변경됨 ㅠㅠ
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("goodmorningmovie").build()   );


        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void 시간_기록기능_추가() {
        LocalDateTime now= LocalDateTime.of(2021,3,9,0,0,0);
        postsRepository.save(Posts.builder()
                .title("제목")
                .content("내용")
                .author("저자는 전지윤")
                .build());

        List<Posts> list = postsRepository.findAll();

        Posts posts = list.get(0);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                "생성시간 = " +posts.getCreatedTime());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +
                "수정시간 = " +posts.getModifiedTime());
        //psotsrepository.save()를 호출한 시간... 아직 업데이트는 안햇으니 ㅎㅎ
        assertThat(posts.getCreatedTime() ).isAfter(now);
        assertThat(posts.getModifiedTime()).isAfter(now);

    }


}
