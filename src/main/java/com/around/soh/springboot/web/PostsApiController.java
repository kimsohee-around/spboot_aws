package com.around.soh.springboot.web;

import com.around.soh.springboot.service.posts.PostsService;
import com.around.soh.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor      //final 로 선언된 모든 필드를 인자값으로 하는 생성자를 롬복에서 대신 생성해준다.
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
