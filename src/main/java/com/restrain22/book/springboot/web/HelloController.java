package com.restrain22.book.springboot.web;

import com.restrain22.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Json으로 리턴하는 컨트롤러로 만들어 준다.
@RestController
public class HelloController {

    //HTTP Method인 Get의 요청을 받을 수 있는 API로 만들어 준다.
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto") //@RequestParam : 외부에서 넘긴 파라미터를 가져오는 어노테이션
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}
