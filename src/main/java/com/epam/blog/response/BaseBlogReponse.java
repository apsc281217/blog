package com.epam.blog.response;

import java.util.List;

public class BaseBlogReponse {
	public enum Status {
		SUCCESS, FAILURE, INVALID_INPUT, UNAUTEHNTICATED
	}

	private Status status;
	private List<String> errorMsgs;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<String> getErrorMsgs() {
		return errorMsgs;
	}

	public void setErrorMsgs(List<String> errorMsgs) {
		this.errorMsgs = errorMsgs;
	}

}
