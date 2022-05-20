package com.restrain22.book.springboot.domain.posts;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest //H2 DB를 자동 실행
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // Junit 단위 테스트가 끝날때마다 수행되는 메소드
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // 테이블 posts에 insert 또는 update 쿼리 시행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("restrain22@naver.com")
                .build());

        //when
        //posts에 있는 모든 데이터 조회
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
