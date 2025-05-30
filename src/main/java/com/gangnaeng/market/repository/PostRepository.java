package com.gangnaeng.market.repository;

import com.gangnaeng.market.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContaining(String keyword);
    List<Post> findAllByOrderByIdDesc();
}
