package com.restrain22.book.springboot.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들도 칼럼으로 인식함
@EntityListeners(AuditingEntityListener.class) //클래스에 Auditing 기능 추가
public abstract class BaseTimeEntity {
    //모든 Entity의 상위 클래스로, Entity들의 createdDate, modifiedDate 자동 관리

    @CreatedDate //Entity 생성될 때, 생성 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //최근 수정 시간 자동 저장
    private LocalDateTime modifiedDate;



}
