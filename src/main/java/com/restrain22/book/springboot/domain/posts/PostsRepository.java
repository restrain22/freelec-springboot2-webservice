package com.restrain22.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//인터페이스 생성 후, JpaRepository를 상속하면 기본적인 CRUD 메소드가 자동 생성
//Entity 클래스와 Entity Repository는 함께 위치해야, Entity는 Repository 없이 제 역할 불가
public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
