package com.gangnaeng.market.dto;

import com.gangnaeng.market.entity.Post;
import com.gangnaeng.market.entity.PostStatus;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String statusText;
    private boolean isSoldOut;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.price = post.getPrice();
        this.isSoldOut = post.getStatus() == PostStatus.SOLDOUT;
        this.statusText = post.getStatus() == null ? "알 수 없음"
                : post.getStatus() == PostStatus.ONSALE ? "판매 중"
                : "거래 완료";
    }


}
