package com.example.kicktheworld_test.Cart.Entity;

import com.example.kicktheworld_test.Security.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name="cart")
@ToString
@Getter
@Setter
@Entity
public class Cart {

    @Id
    @Column(name="cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member; // 구매자

}