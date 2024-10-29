package org.zerock.yuchaemin.spring08.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.yuchaemin.spring08.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Boolean existsByUsername(String username);

    //username을 받아 DB 테이블에서 화면을 조회하는 메소드 작성
    UserEntity findByUsername(String username);
}
