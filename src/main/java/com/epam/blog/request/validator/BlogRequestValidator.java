package com.epam.blog.request.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.epam.blog.request.BlogRequest;
import com.epam.blog.request.CommentRequest;

@Component
public class BlogRequestValidator {

	public List<String> valiateBlogCreationRequest(BlogRequest blogRequest) {
		List<String> errorMsgs = new ArrayList<String>();
		if(blogRequest==null) {
			errorMsgs.add("Invalid blog request");
		}else if(StringUtils.isBlank(blogRequest.getContent())){
			errorMsgs.add("Invalid blog content");
		}else if(StringUtils.isBlank(blogRequest.getTitle())){
			errorMsgs.add("Invalid blog title");
		}
		return errorMsgs;
	}


	public List<String> valiateCommentCreationRequest(CommentRequest commentRequest) {
		List<String> errorMsgs = new ArrayList<String>();
		
		if(commentRequest==null) {
			errorMsgs.add("Invalid comment request");
		}else if(StringUtils.isBlank(commentRequest.getContent())){
			errorMsgs.add("Invalid blog content");
		}else if(StringUtils.isBlank(commentRequest.getArticleId())){
			errorMsgs.add("Invalid Article ID");
		}
		else if(StringUtils.isBlank(commentRequest.getAuthorName())){
			errorMsgs.add("Invalid Author Name");
		}
		else if(StringUtils.isBlank(commentRequest.getAuthorEmail())){
			errorMsgs.add("Invalid Author Email");
		}
		return errorMsgs;
	}

}
