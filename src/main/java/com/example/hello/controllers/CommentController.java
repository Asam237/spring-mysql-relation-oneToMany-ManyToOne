package com.example.hello.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.models.Comment;
import com.example.hello.repositories.CommentRepository;
import com.example.hello.repositories.PostRepository;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/post/{postId}/comment")
	public List<Comment> getAllComment(){
		return commentRepository.findAll();
	}
	
	@PostMapping("/post/{postId}/comment")
	public Optional<Object> createOneComment(@PathVariable Long postId, @RequestBody Comment comment){
		return postRepository.findById(postId).map(post -> {
			comment.setPost(post);
			return commentRepository.save(comment);
		});
	}

}
