package com.vimo.std.springboot.web.domain.posts;

import com.vimo.std.springboot.domain.posts.Posts;
import com.vimo.std.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTests {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void postSaveAndLoad(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jwvimo@gmail.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

        boolean flag = false;
        // map 초기화 및 생성
        Map<String, String> resMap = new HashMap<String, String>();
        resMap.put("test1","1");
        resMap.put("test2","2");
        resMap.put("test3","3");
        resMap.put("rspCode","00000");
        System.out.println("return 1 "+resMap);

        flag = true;
        if(flag){
            resMap.put("rspCode", "S108");
            System.out.println("return 2 "+resMap);
            return;
        }
        // 최종 return

        return;
    }

    @Test
    public void BaseTimeEnitty_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2023,9,19,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("JPA~")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>> createDate= "+ posts.getCreatedDate() + ", >>>> modifiedDate = "+posts.getModifiedDate());

        assertThat(posts.getCreatedDate().isAfter(now));
        assertThat(posts.getModifiedDate().isAfter(now));
    }

}
