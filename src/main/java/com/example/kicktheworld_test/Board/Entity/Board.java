package com.example.kicktheworld_test.Board.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Table(name="board")
@Entity
@Getter
@NoArgsConstructor

public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="mem_id")
    private String mem_id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="category")
    private String category;

    @CreatedDate
    @Column(name="created_at")
    private Date created_at;

    @LastModifiedDate
    @Column(name="updated_at")
    private Date updated_at;

    @Builder
    public Board(String mem_id, String title, String content, String category, Date created_at, Date updated_at){
        this.mem_id = mem_id;
        this.title = title;
        this.content = content;
        this.category = category;
//        this.created_at = created_at;
//        this.updated_at = updated_at;
    }

    public void update(String title, String content, String category){
        this.title = title;
        this.content = content;
        this.category = category;
//        this.updated_at = updated_at;
    }

}
