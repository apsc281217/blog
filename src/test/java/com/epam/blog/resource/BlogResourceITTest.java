package com.epam.blog.resource;

import static io.restassured.RestAssured.with;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;;
public class BlogResourceITTest {

	@Test
	public void test() {
		with().header("epam-traceId", "stub~trace~id").get("/retrieveArticles/123").then().statusCode(200)
		.assertThat().body("status", equalTo("SUCCESS"));
	}

}
