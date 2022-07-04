package com.study.springbootwebservice.controller;

import com.study.springbootwebservice.dto.PostsResponseDto;
import com.study.springbootwebservice.dto.PostsSaveRequestDto;
import com.study.springbootwebservice.dto.PostsUpdateRequestDto;
import com.study.springbootwebservice.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor    //final 필드 생성자 생성
@RestController     //Controller과는 다르게 JOSN 형태로 객체 데이터 반환
public class PostsApiController {

    private final PostsService postsService;

    // 게시물 저장
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    // 게시물 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    // 게시물 조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    // 게시물 삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
