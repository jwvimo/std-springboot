package com.vimo.std.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
* JpaRepository 상속으로 @Repository 없이도 기본 CRUD 메소드가 자동으로 생성된다
* Entity 클래스 없이는 제대로 동작할 수 없으므로 같은 도메인 패키지에 있어야 한다.
* JpaRepository<Entity 클래스, PK타입>
* */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
