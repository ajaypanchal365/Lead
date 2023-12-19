package com.lead.demo.apiResponse;

import com.lead.demo.entity.Lead;

public class ApiResponse {

	
	    private String status;
	    private Object data;
	    
		public ApiResponse(String string, Object response) {
			
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
	    

	}

	

	
