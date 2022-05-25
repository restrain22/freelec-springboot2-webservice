package com.restrain22.book.springboot.web;

import com.restrain22.book.springboot.service.posts.PostsService;
import com.restrain22.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor //선언된 모든 final 필드가 포함된 생성자를 생성, final이 아닌 필드는 생성자 X
@RestController //Json으로 리턴하는 컨트롤러로 만들어 준다.
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestParam PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}