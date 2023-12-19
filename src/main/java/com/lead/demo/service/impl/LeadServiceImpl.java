package com.lead.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lead.demo.apiResponse.ApiErrorResponse;
import com.lead.demo.apiResponse.ApiResponse;
import com.lead.demo.entity.Lead;
import com.lead.demo.exception.LeadValidationException;
import com.lead.demo.repository.LeadRepository;
import com.lead.demo.service.LeadService;

@Service
public class LeadServiceImpl implements LeadService{
	@Autowired
	private LeadRepository leadRepository;

	@Override
	public String saveLeadDetails(Lead lead) {
		  validateLead(lead);
        leadRepository.save(lead);
        return "Created Leads Successfully";
	}
	
	
	 private void validateLead(Lead lead) {
	        validateLeadId(lead.getLeadId());
	        validateFirstName("First Name", lead.getFirstName());
	        validateMiddleName("Last Name", lead.getLastName());
	        validateLastName("Last Name", lead.getLastName());
	        validateMobileNumber(lead.getMobileNumber());
	        validateGender(lead.getGender());
	        validateDateOfBirth(lead.getDob());
	        validateEmail(lead.getEmail());

	        // Additional validations can be added here
	    }

	    private void validateLeadId(Long leadId) {
	        
	        if (leadRepository.existsById(leadId)) {
	            throw new LeadValidationException("lead id","Lead ID must be unique");
	        }
	    }

	    private void validateFirstName(String FirstName, String value) {
	        if (value == null || !value.matches("[A-Za-z]+")) {
	            throw new LeadValidationException(FirstName , " should contain alphabets only and is mandatory");
	        }
	    }
	    private void validateMiddleName(String MiddleName, String value) {
	        if (value == null || !value.matches("[A-Za-z]+")) {
	            throw new LeadValidationException(MiddleName , " should contain alphabets only and is mandatory");
	        }
	    }
	    private void validateLastName(String LastName, String value) {
	        if (value == null || !value.matches("[A-Za-z]+")) {
	            throw new LeadValidationException(LastName , " should contain alphabets only and is mandatory");
	        }
	    }

	    private void validateMobileNumber(Long mobileNumber) {
	        if (mobileNumber == null || mobileNumber.toString().length() != 10 || mobileNumber.toString().charAt(0) <= '5') {
	            throw new LeadValidationException("mobileNumber" ,"Mobile Number should be a 10-digit number with the first digit greater than 5");
	        }
	    }

	    private void validateGender(String gender) {
	        if (gender == null || !gender.matches("Male|Female|Others")) {
	            throw new LeadValidationException(gender,"Gender should be Male, Female, or Others and is mandatory");
	        }
	    }

	    private void validateDateOfBirth(Date dob) {
	        if (dob == null) {
	            throw new LeadValidationException("Date","Date of Birth is mandatory");
	        }
	       
	    }

	    private void validateEmail(String email) {
	        if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
	            throw new LeadValidationException(email,"Email should be a valid email address and is mandatory");
	        }

	       
	    }
	



	@Override
	public List<Lead> findByMobileNumber(Long mobileNumber) {
		List<Lead> leads = leadRepository.findByMobileNumber(mobileNumber);
        if (leads.isEmpty()) {
            return (List<Lead>) new ApiResponse("error", new ApiErrorResponse("E10011", "No Lead found with the Mobile Number " + mobileNumber));
        } else {
            return (List<Lead>) new ApiResponse("success", leads);
        }
	}

}
