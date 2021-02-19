package com.example.hello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hello.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
