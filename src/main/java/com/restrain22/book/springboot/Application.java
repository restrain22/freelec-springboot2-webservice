package com.restrain22.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
  특히 @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에
  항상 프로젝트의 최상단에 위치해야 함.
*/
@SpringBootApplication
//앞으로 만들 프로젝트의 Main Class
public class Application {
    public static void main(String[] args) {
        //내장 WAS 실행 > 서버에 톰캣 설치 필요 X/Jar 파일로 실행 가능
        SpringApplication.run(Application.class,args);
    }
}
