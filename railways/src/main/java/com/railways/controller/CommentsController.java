package com.railways.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.railways.model.Comments;
import com.railways.service.CommentsServcie;

@Controller
public class CommentsController {

	@Autowired
	private CommentsServcie commentsService;
	
	@GetMapping("/comments")
	public String saveCommens(String comments, ModelMap model) {
		
		Comments comment = new Comments(comments);
		commentsService.saveComments(comment);
		
		model.put("successMsg", "Thank You! for Your Valuable Suggestions, We will Improve our Site");
		
		return "success";
	}
}
