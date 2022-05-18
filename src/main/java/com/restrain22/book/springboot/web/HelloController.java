package com.restrain22.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Json으로 리턴하는 컨트롤러로 만들어 준다.
@RestController
public class HelloController {

    //HTTP Method인 Get의 요청을 받을 수 있는 API로 만들어 준다.
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
