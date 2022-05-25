package com.restrain22.book.springboot.web;

import com.restrain22.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자 실행
//스프링부트 테스트와 JUnit 사이에 연결자 역할
@RunWith(SpringRunner.class)
//Web(Spring MVC)에 집중할 수 있는 어노테이션, @controller만 사용가능
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    //스프링이 관리하는 빈을 주입 받음
    @Autowired
    //웹 API 테스트할 때 사용
    //스프링 MVC 테스트의 시작점, HTTP Method에 대한 API 테스트 가능
    private MockMvc mvc;


    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //HTTP Get 요청을 함
                .andExpect(status().isOk()) //mvc.perform의 결과 검증, HTTP Header의 Status 검증
                .andExpect(content().string(hello)); //응답 본문의 내용 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) //jsonPath : JSON 응답값을 필드별로 검증
                .andExpect(jsonPath("$.amount",is(amount))); //$를 기준으로 필드명을 명시
    }
}
