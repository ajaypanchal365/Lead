package com.lead.demo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lead.demo.apiResponse.ApiResponse;
import com.lead.demo.controller.LeadController;
import com.lead.demo.entity.Lead;
import com.lead.demo.repository.LeadRepository;
import com.lead.demo.service.LeadService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class LeadApplicationTests {
	
	@Autowired
	private LeadService service;

	@MockBean
	private LeadRepository repository;

	
	  @Autowired
	    private MockMvc mockMvc;

	    @Mock
	    private LeadService leadService;

	    @InjectMocks
	    private LeadController leadController;

	    @Test
	    public void testCreateLead() {
	        Lead lead = new Lead();
	        lead.setLeadId((long) 111);
	        lead.setFirstName("madhu");
	        lead.setMiddleName("xyz");
	       
	        lead.setLastName("gaik");
	        lead.setGender("female");
	        lead.setEmail("madhu@gmail.com");
	       
	        
	     // Set DOB
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        try {
	            Date dob = dateFormat.parse("01/01/1990");
	            lead.setDob(dob);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	        Mockito.when(leadService.saveLeadDetails(any(Lead.class))).thenReturn("Created Leads Successfully");

	        ResponseEntity<?> responseEntity = leadController.createLead(lead);

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        //assertEquals("success", ((ApiResponse) responseEntity.getBody()).getStatus());
	    }
	    
	    
}
