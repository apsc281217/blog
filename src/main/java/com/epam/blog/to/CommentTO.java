package com.epam.blog.to;

public class CommentTO {
	private String id;
	private String authorId;
	private String authorEmailId;
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorEmailId() {
		return authorEmailId;
	}

	public void setAuthorEmailId(String authorEmailId) {
		this.authorEmailId = authorEmailId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
