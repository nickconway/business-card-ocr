package dev.conway.businesscardparser;

interface BusinessCardParser{

	// Parse document for contact information
	ContactInfo getContactInfo(String document);

}