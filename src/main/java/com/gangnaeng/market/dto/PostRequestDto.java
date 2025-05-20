package com.gangnaeng.market.dto;

import com.gangnaeng.market.entity.Post;
import com.gangnaeng.market.entity.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostRequestDto {
    private String title;
    private String content;
    private int price;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .price(price)
                .status(PostStatus.ONGOING)
                .build();
    }
}
