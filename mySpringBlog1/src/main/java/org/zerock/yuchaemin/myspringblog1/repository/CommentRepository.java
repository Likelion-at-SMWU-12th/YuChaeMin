package org.zerock.yuchaemin.myspringblog1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.yuchaemin.myspringblog1.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
