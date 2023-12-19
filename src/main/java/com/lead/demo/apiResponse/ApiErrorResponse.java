package com.lead.demo.apiResponse;

public class ApiErrorResponse {
	private String code;
	private String messages;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public ApiErrorResponse(String code, String string) {
		super();
		this.code = code;
		this.messages = string;
	}

	
}
