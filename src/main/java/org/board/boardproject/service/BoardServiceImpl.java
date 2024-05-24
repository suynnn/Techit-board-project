package org.board.boardproject.service;

import lombok.RequiredArgsConstructor;
import org.board.boardproject.domain.Board;
import org.board.boardproject.dto.BoardRegisterDto;
import org.board.boardproject.dto.BoardUpdateDto;
import org.board.boardproject.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Board> findPaginated(Pageable pageable) {
        Pageable sortedByDescId = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "id"));

        return boardRepository.findAll(sortedByDescId);
    }

    @Override
    @Transactional(readOnly = true)
    public Board findById(Long id) {

        return boardRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void saveBoard(BoardRegisterDto boardRegisterDto) {

        Board board = Board.builder()
                .name(boardRegisterDto.getName())
                .title(boardRegisterDto.getTitle())
                .password(boardRegisterDto.getPassword())
                .content(boardRegisterDto.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        boardRepository.save(board).getId();
    }

    @Override
    public boolean verifyPassword(Long id, String password) {
        String storedPassword = findById(id).getPassword();

        return storedPassword.equals(password);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(BoardUpdateDto boardUpdateDto) {
        Board board = findById(boardUpdateDto.getId());

        board.setName(boardUpdateDto.getName());
        board.setTitle(boardUpdateDto.getTitle());
        board.setContent(boardUpdateDto.getContent());
        board.setUpdatedAt(LocalDateTime.now());

        boardRepository.save(board);
    }
}
