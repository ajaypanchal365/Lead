package com.lead.demo.exception;

public class LeadAlreadyPresent extends RuntimeException {

	public LeadAlreadyPresent(String message) {
        super(message);
}

}