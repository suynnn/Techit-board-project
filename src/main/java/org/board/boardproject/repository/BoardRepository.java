package org.board.boardproject.repository;

import org.board.boardproject.domain.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long>, PagingAndSortingRepository<Board, Long> {
}
