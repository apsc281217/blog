package com.epam.blog.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.blog.to.ArticleTO;
import com.epam.blog.to.CommentTO;
@Component
public class BlogDao {

	public void insertBlog(ArticleTO articleTO) {
		// Integrate with selected DB, not implemented on purpose.
	}

	public void updateBlog(ArticleTO articleTO) {
		// TODO Auto-generated method stub
		
	}

	public List<ArticleTO> getArticlesByAuthorId(String authorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addComment(CommentTO commentTO) {
		// TODO Auto-generated method stub
	}

}
