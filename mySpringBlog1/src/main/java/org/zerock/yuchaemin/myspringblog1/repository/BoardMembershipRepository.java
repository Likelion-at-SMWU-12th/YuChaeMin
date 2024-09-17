package org.zerock.yuchaemin.myspringblog1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.yuchaemin.myspringblog1.entity.BoardMembership;

public interface BoardMembershipRepository extends JpaRepository<BoardMembership, Long> {
}
