package com.epam.blog.resource;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.epam.blog.request.BlogRequest;
import com.epam.blog.request.CommentRequest;
import com.epam.blog.request.validator.BlogRequestValidator;
import com.epam.blog.response.BaseBlogReponse.Status;
import com.epam.blog.response.BlogResponse;
import com.epam.blog.service.BlogService;
import com.epam.blog.to.ArticleTO;

@RestController
public class BlogResource {

	@Autowired
	private BlogRequestValidator validator;

	@Autowired
	private BlogService service;

	@PostMapping(path = "/createUpdateBlog")
	public BlogResponse create(BlogRequest blogRequest, @RequestHeader("epam-loginId") String loginId,
			@RequestHeader("epam-traceId") String traceId) {
		BlogResponse response = new BlogResponse();
		try {

			/*
			 * Assumption: rest endpoint is behind application gateway, which is responsible
			 * for Autentication validation and setting appropriates request headers for
			 * underlaying endpoints.
			 */

			/*
			 * Trace id is basically used as transaction ID for debugging.
			 */

			if (StringUtils.isBlank(loginId)) {
				response.setStatus(Status.UNAUTEHNTICATED);
			} else {

				List<String> errorMsgs = validator.valiateBlogCreationRequest(blogRequest);
				if (CollectionUtils.isNotEmpty(errorMsgs)) {
					response.setErrorMsgs(errorMsgs);
					response.setStatus(Status.INVALID_INPUT);
				} else {
					service.createUpdateBlog(blogRequest, loginId);
					response.setStatus(Status.SUCCESS);
				}
			}
		} catch (Exception e) {
			// Ideally we should create Custom application level exception.
			response.setStatus(Status.FAILURE);
			response.setErrorMsgs(Arrays.asList(new String[] { "Exception while creating blog" }));
		}

		return response;
	}

	@GetMapping(path = "/retrieveArticles/{authorId}")
	public BlogResponse getArticles(@RequestHeader("epam-traceId") String traceId, @PathVariable String authorId) {
		BlogResponse response = new BlogResponse();
		try {
			if (StringUtils.isBlank(authorId)) {
				response.setStatus(Status.INVALID_INPUT);
			} else {
				List<ArticleTO> articles= service.getArticlesByAuthorId(authorId);
				
				response.setStatus(Status.SUCCESS);
				response.setArticles(articles);
			}
		} catch (Exception e) {
			response.setStatus(Status.FAILURE);
			response.setErrorMsgs(Arrays.asList(new String[] { "Exception while fetching articles" }));
		}

		return response;
	}
	
	@PostMapping(path = "/addComment")
	public BlogResponse addComment(CommentRequest commentRequest, @RequestHeader("epam-traceId") String traceId) {
		BlogResponse response = new BlogResponse();
		try {
				List<String> errorMsgs = validator.valiateCommentCreationRequest(commentRequest);
				if (CollectionUtils.isNotEmpty(errorMsgs)) {
					response.setErrorMsgs(errorMsgs);
					response.setStatus(Status.INVALID_INPUT);
				} else {
					service.addComment(commentRequest);
					response.setStatus(Status.SUCCESS);
				}
		} catch (Exception e) {
			// Ideally we should create Custom application level exception.
			response.setStatus(Status.FAILURE);
			response.setErrorMsgs(Arrays.asList(new String[] { "Exception while creating comment" }));
		}

		return response;
	}

}
