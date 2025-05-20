package com.gangnaeng.market.dto;

import com.gangnaeng.market.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String statusText;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.price = post.getPrice();
        this.statusText = post.getStatus() == null ? "알 수 없음"
                : post.getStatus() == com.gangnaeng.market.entity.PostStatus.ONGOING ? "판매 중"
                : "거래 완료";
    }
}
