package com.example.hello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hello.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
