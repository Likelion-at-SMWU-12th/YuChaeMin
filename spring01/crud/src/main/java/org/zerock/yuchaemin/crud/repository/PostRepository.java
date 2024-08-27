package org.zerock.yuchaemin.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.zerock.yuchaemin.crud.entity.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
