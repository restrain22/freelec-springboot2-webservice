package com.restrain22.book.springboot.domain.posts;

import com.restrain22.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity //테이블과 링크될 클래스를 나타냄, 클래스의 카멜케이스 이름을 언더스코터 네이밍(_)으로 테이블 이름을 매칭
        //실제 DB 테이블과 매칭될 클래스 = Entity 클래스
public class Posts extends BaseTimeEntity {
    //Entity에서는 Setter 메소드를 절대 만들지 않음 > 어디서 변해야 하는지 구분할 수 없어, 복잡해지기 때문
    //생성자를 통해 값을 채워야 함. 값 변경이 필요한 경우, 해당 이벤트에 맞는 public 메소드 호출을 통해 수정

    @Id //해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성 규칙, 스프링부트 2.0에선 identity를 추가해야 auto_increment가 됨
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼, 굳이 선언하지 않아도 해당 클래스의 필드는 모두 컬럼이다.
    private String title;                   // 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있는 경우, 문자열의 경우 VARCHAR(255)가 기본값

    @Column(columnDefinition = "TEXT", nullable = false) // columnDefinition : 특정 필드의 타입을 지정하여 데이터를 추출
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더 포함
             // 생성자나 빌더나 생성지점에 값을 채워주는 역할
             // 빌더를 사용하면 어느 필드에 어떤 값을 채워야 할지 명확하게 인지
    public Posts(String title, String content, String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
