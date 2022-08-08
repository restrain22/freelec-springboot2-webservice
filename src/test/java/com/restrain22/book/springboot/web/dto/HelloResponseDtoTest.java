package com.restrain22.book.springboot.web.dto;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //assertj라는 테스트 검증 라이브러리의 검증 메소드, 검증받고 싶은 대상을 인자로 받음
        //Junit의 assertThat이 아니라 assertj의 assertThat을 쓴 이유는 추가적인 라이브러리가 필요없고, 자동완성이 더 지원 잘 됨.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
