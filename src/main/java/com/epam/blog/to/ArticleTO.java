package com.epam.blog.to;

import java.util.Date;
import java.util.List;

public class ArticleTO {
	private String id;
	private String userId;
	private String title;
	private String content;
	private Date creationDate;
	private Date lastUpdateDate;
	private List<CommentTO> comments;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<CommentTO> getComments() {
		return comments;
	}
	public void setComments(List<CommentTO> comments) {
		this.comments = comments;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	
	
	
}
