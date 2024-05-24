package org.board.boardproject.service;

import org.board.boardproject.domain.Board;
import org.board.boardproject.dto.BoardRegisterDto;
import org.board.boardproject.dto.BoardUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    Page<Board> findPaginated(Pageable pageable);

    Board findById(Long id);

    void saveBoard(BoardRegisterDto boardRegisterDto);

    boolean verifyPassword(Long id, String password);

    void deleteById(Long id);

    void update(BoardUpdateDto boardUpdateDto);
}
