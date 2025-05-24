package com.gangnaeng.market.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;  //제목
    private String content;  //내용
    private Integer price;  //가격

    @Enumerated(EnumType.STRING)
    private PostStatus status;  //거래 상태

}

