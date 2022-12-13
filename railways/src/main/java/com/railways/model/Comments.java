package com.railways.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comments {

	@Id
	@GeneratedValue
	private Integer id;
	private String comments;

	public Comments() {
		super();
	}

	public Comments(String comments) {
		super();
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", comments=" + comments + "]";
	}

}
