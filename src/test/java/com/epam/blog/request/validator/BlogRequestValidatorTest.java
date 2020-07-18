package com.epam.blog.request.validator;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.blog.request.BlogRequest;
@RunWith(SpringRunner.class)
public class BlogRequestValidatorTest {

	@InjectMocks
	private BlogRequestValidator validator;
	
	@Test
	public void testValiateBlogCreationRequest() {
		BlogRequest blogRequest = Mockito.mock(BlogRequest.class);
		
		Mockito.when(blogRequest.getId()).thenReturn("id");
		Mockito.when(blogRequest.getTitle()).thenReturn("title");
		Mockito.when(blogRequest.getContent()).thenReturn("content");

		List<String> errorMsgs = validator.valiateBlogCreationRequest(blogRequest );
		
		assertTrue(CollectionUtils.isEmpty(errorMsgs));
	}
	
	
	
	@Test
	public void testValiateBlogCreationRequestInvalidTitle() {
		BlogRequest blogRequest = Mockito.mock(BlogRequest.class);
		
		Mockito.when(blogRequest.getId()).thenReturn("id");
		Mockito.when(blogRequest.getTitle()).thenReturn(null);
		Mockito.when(blogRequest.getContent()).thenReturn("content");

		List<String> errorMsgs = validator.valiateBlogCreationRequest(blogRequest );
		
		assertFalse(CollectionUtils.isEmpty(errorMsgs));
	}
	
	@Test
	public void testValiateBlogCreationRequestInvalidContent() {
		BlogRequest blogRequest = Mockito.mock(BlogRequest.class);
		
		Mockito.when(blogRequest.getId()).thenReturn("id");
		Mockito.when(blogRequest.getTitle()).thenReturn("title");
		Mockito.when(blogRequest.getContent()).thenReturn(null);

		List<String> errorMsgs = validator.valiateBlogCreationRequest(blogRequest );
		
		assertFalse(CollectionUtils.isEmpty(errorMsgs));
	}
}
