package com.lead.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lead.demo.apiResponse.ApiError;
import com.lead.demo.apiResponse.ApiErrorResponse;
import com.lead.demo.apiResponse.ApiResponse;
import com.lead.demo.entity.Lead;
import com.lead.demo.exception.LeadValidationException;
import com.lead.demo.service.LeadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class LeadController {

	@Autowired
	private LeadService leadService;

	@PostMapping("/create")
	
	    public ResponseEntity<?> createLead(@RequestBody Lead lead) {
		try {
            String response = leadService.saveLeadDetails(lead);
            return ResponseEntity.ok(new ApiResponse("success", response));
        } catch (LeadValidationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new ApiError("error", new ApiErrorResponse("E10010", e.getMessage())));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

	}
	
	
	@GetMapping("/{mobileNumber}")
    public ApiResponse getLeadByMobileNumber(@PathVariable Long mobileNumber) {
        return (ApiResponse) leadService.findByMobileNumber(mobileNumber);
    }
}
