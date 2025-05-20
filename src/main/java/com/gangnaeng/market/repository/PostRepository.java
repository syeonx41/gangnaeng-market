package com.gangnaeng.market.repository;

import com.gangnaeng.market.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
