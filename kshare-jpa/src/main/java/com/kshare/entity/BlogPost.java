package com.kshare.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value = "blog_post")
@PrimaryKeyJoinColumn(name = "blog_post_id")
public class BlogPost extends Publication {
	private String url;

	public BlogPost() {
		super("Love");
	}

	public BlogPost(String url) {
		super("Fight");
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
