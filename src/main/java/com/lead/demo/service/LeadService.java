package com.lead.demo.service;

import java.util.List;

import com.lead.demo.entity.Lead;

public interface LeadService {
	
	public String saveLeadDetails(Lead lead);
	
	public List<Lead> findByMobileNumber(Long mobileNumber);
	

}
