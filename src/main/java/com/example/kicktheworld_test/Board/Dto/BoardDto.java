package com.example.kicktheworld_test.Board.Dto;

import com.example.kicktheworld_test.Board.Entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardDto {

    private Long id;
    private String mem_id;
    private String title;
    private String content;
    private String category;
    private Date created_at;
    private Date updated_at;

    // entity -> dto
    public static BoardDto fromEntity(Board board){
        return new BoardDto(
                board.getId(),
                board.getMem_id(),
                board.getTitle(),
                board.getContent(),
                board.getCategory(),
                board.getCreated_at(),
                board.getUpdated_at()
        );
    }

    public static List<BoardDto> listFromEntity(List<Board> boards){
        return boards.stream()
                .map(BoardDto::fromEntity)
                .collect(Collectors.toList());
    }

    public static List<Board> listToEntity(List<BoardDto> boardDtos){
        return boardDtos.stream()
                .map(BoardDto::toEntity)
                .collect(Collectors.toList());
    }

    // dto -> entity
    public Board toEntity(){
        return Board.builder()
//                .id(id)
                .mem_id(mem_id)
                .title(title)
                .content(content)
                .category(category)
                .created_at(created_at)
                .updated_at(updated_at)
                .build();
    }

    // update
    public void updateEntity(Board board) { board.update(title, content, category); }

}
