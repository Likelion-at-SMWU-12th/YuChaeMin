package org.zerock.yuchaemin.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.zerock.yuchaemin.crud.entity.BoardEntity;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}
