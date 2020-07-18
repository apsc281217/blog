package com.epam.blog.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.blog.dao.BlogDao;
import com.epam.blog.request.BlogRequest;
import com.epam.blog.request.CommentRequest;
import com.epam.blog.to.ArticleTO;
import com.epam.blog.to.CommentTO;
@Service
public class BlogService {
	
	@Autowired
	private BlogDao dao;
	
	public void createUpdateBlog(BlogRequest blogRequest, String loginId) {
		
		ArticleTO articleTO = new ArticleTO();
		
		articleTO.setUserId(loginId);
		articleTO.setTitle(blogRequest.getTitle());
		articleTO.setContent(blogRequest.getContent());
		
		if(StringUtils.isNotBlank(blogRequest.getId())) {
			articleTO.setId(blogRequest.getId());
			dao.updateBlog(articleTO);
		}else {
			dao.insertBlog(articleTO);		
		}
	}

	public List<ArticleTO> getArticlesByAuthorId(String authorId) {
		return dao.getArticlesByAuthorId(authorId);
	}

	public void addComment(CommentRequest commentRequest) {
		CommentTO commentTO = new CommentTO();
		dao.addComment(commentTO);
	}
	
	

}
