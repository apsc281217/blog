package com.epam.blog.response;

import java.util.List;

import com.epam.blog.to.ArticleTO;

public class BlogResponse extends BaseBlogReponse{
	private List<ArticleTO> articles;

	public List<ArticleTO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleTO> articles) {
		this.articles = articles;
	}
	
	
}
