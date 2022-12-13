package com.railways.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railways.model.Comments;
import com.railways.repository.CommentsRepository;

@Service
public class CommentsServcie {

	@Autowired
	private CommentsRepository commentsRepository;
	
	public void saveComments(Comments comments) {
		commentsRepository.save(comments);
	}
}
