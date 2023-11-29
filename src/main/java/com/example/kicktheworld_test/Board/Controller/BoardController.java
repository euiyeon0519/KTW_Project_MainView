package com.example.kicktheworld_test.Board.Controller;


import com.example.kicktheworld_test.Board.Dto.BoardDto;
import com.example.kicktheworld_test.Board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    // 전체 조회 뷰
    @GetMapping
    public String getBoards(Model model){
        List<BoardDto> boardDtos = boardService.findAll();
        model.addAttribute("boards", boardDtos);

        return "board/boardList";
    }

    // 상세 조회 뷰
    @GetMapping("/{id}")
    public String getBoard(@PathVariable Long id, Model model) {
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);

        return "board/boardDetail";
    }

    // 등록 뷰
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/create")
    public String newBoard(@RequestParam(required = false) Long id, Model model){
        if(id==null){
            model.addAttribute("board", new BoardDto());
        } else {
            BoardDto boardDto = boardService.findById(id);
            model.addAttribute("board", boardDto);
        }

        return "board/createBoard";
    }

    // 등록 처리
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<BoardDto> addBoard(@RequestBody BoardDto boardDto){
        BoardDto savedBoardDto = boardService.save(boardDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedBoardDto);
    }

    // 수정 뷰
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/edit/{id}")
    public String editBoard(@PathVariable Long id, Model model){
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);

        return "board/editBoard";
    }

    // 수정 처리
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/edit/{id}")
    public ResponseEntity<BoardDto> updateBoard(@PathVariable Long id, @RequestBody BoardDto boardDto){
        BoardDto updatedBoardDto = boardService.update(id, boardDto);

        return ResponseEntity.ok()
                .body(updatedBoardDto);
    }

    // 삭제 처리
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id){
        boardService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
}





