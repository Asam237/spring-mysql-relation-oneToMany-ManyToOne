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

import com.example.hello.models.Post;
import com.example.hello.repositories.PostRepository;
import com.example.hello.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class PostController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/user/{userId}/posts")
	public List<Post> getAllPost(){
		return postRepository.findAll();
	}
	
	@PostMapping("/user/{userId}/posts")
	public Optional<Object> createOnePost(@PathVariable Long userId, @RequestBody Post post){
		return userRepository.findById(userId).map(user -> {
			post.setUser(user);
			return postRepository.save(post);
		});
	}

}
