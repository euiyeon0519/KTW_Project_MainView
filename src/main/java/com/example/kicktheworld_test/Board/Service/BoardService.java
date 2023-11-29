package com.example.kicktheworld_test.Board.Service;

import com.example.kicktheworld_test.Board.Dto.BoardDto;
import com.example.kicktheworld_test.Board.Entity.Board;
import com.example.kicktheworld_test.Board.Repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // 추가
    @Secured("ROLE_USER")
    public BoardDto save(BoardDto boardDto) {
        Board savedBoard = boardRepository.save(boardDto.toEntity());
        return BoardDto.fromEntity(savedBoard);
    }

    // 전체 조회
    public List<BoardDto> findAll() {
        List<Board> boards = boardRepository.findAll();
        return BoardDto.listFromEntity(boards);
    }

    // 단건 조회
    public BoardDto findById(long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        return BoardDto.fromEntity(board);
    }

    // 삭제
    @Secured("ROLE_USER")
    public void delete(long id) {
        boardRepository.deleteById(id);
    }

    // 수정
    @Secured("ROLE_USER")
    @Transactional
    public BoardDto update(long id, BoardDto boardDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        boardDto.updateEntity(board);
        return BoardDto.fromEntity(board);
    }
}