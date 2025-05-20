package com.gangnaeng.market.controller;

import com.gangnaeng.market.dto.PostRequestDto;
import com.gangnaeng.market.dto.PostResponseDto;
import com.gangnaeng.market.entity.Post;
import com.gangnaeng.market.entity.PostStatus;
import com.gangnaeng.market.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items/posts")
public class PostController {

    private final PostRepository postRepository;

    //게시글 작성 폼
    @GetMapping("/create")
    public String showCreateForm() {
        return "items/create"; //create.mustache
    }

    //게시글 작성
    @PostMapping
    public String create(Post post) {
        postRepository.save(post);
        return "redirect:/items/posts"; //목록 페이지로 페이지 이동
    }

    //전체 게시글 목록 조회
    @GetMapping
    public String list(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        List<PostResponseDto> postList = new ArrayList<>();
        for (Post post : posts) {
            postList.add(new PostResponseDto(post));
        }
        model.addAttribute("postList", postList);
        return "items/list"; //list.mustache
    }

    //게시글 상세 보기
    @GetMapping("/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        PostResponseDto dto = new PostResponseDto(post);
        model.addAttribute("post", dto);
        return "items/detail";  //detail.mustache
    }

    //게시글 수정 폼 조회
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        PostResponseDto dto = new PostResponseDto(post);
        model.addAttribute("post", dto);
        return "items/edit"; //edit.mustache
    }

    //게시글 수정
    @PostMapping("/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute PostRequestDto form) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setPrice(form.getPrice());
        postRepository.save(post);
        return "redirect:/items/posts/" + id; //상세 페이지로 페이지 이동
    }

    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return "redirect:/items/posts"; //목록 페이지로 페이지 이동
    }

    @PostMapping("/{id}/complete")
    public String completePost(@PathVariable Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        post.setStatus(PostStatus.COMPLETE);
        postRepository.save(post);
        return "redirect:/items/posts/" + id; //상세 페이지로 페이지 이동
    }

    //게시글 검색
    @GetMapping("/items/posts/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Post> posts = postRepository.findByTitleContaining(keyword);
        List<PostResponseDto> postList = posts.stream()
                .map(PostResponseDto::new)
                .toList();
        model.addAttribute("postList", postList);
        return "items/list"; //list.mustache
    }

}
