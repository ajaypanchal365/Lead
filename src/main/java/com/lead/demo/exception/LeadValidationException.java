package com.lead.demo.exception;

public class LeadValidationException extends RuntimeException {

//	public LeadAlreadyPresent(String message) {
//        super(message);
//}
	
	private final String fieldName;

    public LeadValidationException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    // Factory methods for common validation scenarios

    public static LeadValidationException leadIdMandatory() {
        return new LeadValidationException("LeadId", "Lead ID is mandatory");
    }

    public static LeadValidationException leadIdNotUnique() {
        return new LeadValidationException("LeadId", "Lead ID must be unique");
    }

    public static LeadValidationException firstNameInvalid() {
        return new LeadValidationException("FirstName", "First Name should contain alphabets only and is mandatory");
    }

    public static LeadValidationException middleNameInvalid() {
        return new LeadValidationException("MiddleName", "Middle Name should contain alphabets only");
    }

    public static LeadValidationException lastNameInvalid() {
        return new LeadValidationException("LastName", "Last Name should contain alphabets only and is mandatory");
    }

    public static LeadValidationException mobileNumberInvalid() {
        return new LeadValidationException("MobileNumber", "Mobile Number should be a 10-digit number with the first digit greater than 5 and is mandatory");
    }

    public static LeadValidationException genderInvalid() {
        return new LeadValidationException("Gender", "Gender should be Male, Female, or Others and is mandatory");
    }

    public static LeadValidationException dobInvalid() {
        return new LeadValidationException("DOB", "Date of Birth is mandatory");
    }

    public static LeadValidationException emailInvalid() {
        return new LeadValidationException("Email", "Email should be a valid email address and is mandatory");
    }

    public static LeadValidationException emailNotUnique() {
        return new LeadValidationException("Email", "Email must be unique");
    }

}