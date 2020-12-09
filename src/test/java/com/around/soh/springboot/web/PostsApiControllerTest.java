package com.around.soh.springboot.web;

import com.around.soh.springboot.domain.posts.PostRepository;
import com.around.soh.springboot.domain.posts.Posts;
import com.around.soh.springboot.web.dto.PostsSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostRepository postRepository;

    @AfterEach
    public void tearDown() throws Exception{
        postRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception{
        String title="테스트 게시글11";
        String content="테스트 본문11";

        PostsSaveRequestDto requestDto=PostsSaveRequestDto.builder()
                   .title(title).content(content).author("choirenii@gmail.com").build();

        String url = "http://localhost:" + port +"/api/v1/posts";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url,requestDto,Long.class);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assumeTrue(responseEntity.getBody() > 0L);

        List<Posts> all = postRepository.findAll();
        assertEquals(all.get(0).getTitle(),title);
        assertEquals(all.get(0).getContent(),content);
    }
}