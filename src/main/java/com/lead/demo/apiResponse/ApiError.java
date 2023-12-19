package com.lead.demo.apiResponse;

public class ApiError {
	private String status;
	private ApiErrorResponse errorResponse;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ApiErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ApiErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public ApiError(String status, ApiErrorResponse errorResponse) {
		super();
		this.status = status;
		this.errorResponse = errorResponse;
	}

	
}