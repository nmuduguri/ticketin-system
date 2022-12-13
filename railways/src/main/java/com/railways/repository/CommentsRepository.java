package com.railways.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.railways.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {

}
