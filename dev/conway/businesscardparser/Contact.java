package dev.conway.businesscardparser;

public class Contact implements ContactInfo{

	// Class members
	private String name;
	private String phone;
	private String email;

	// Constructor: Contact()
	// Takes a name, phone number, and email string, and sets the object's members to those strings, respectively
	Contact(String name, String phone, String email){

		this.name = name;
		this.phone = phone;
		this.email = email;

	}

	// Implementation of the getName() method in ContactInfo
	// returns the full name of the individual (eg. John Smith, Susan Malick)
	public String getName(){
		return this.name;
	}

	// Implementation of the getPhoneNumber() method in ContactInfo
	// returns the phone number formatted as a sequence of digits
	public String getPhoneNumber(){
		return this.phone;
	}

	// Implementation of the getEmailAddress() method in ContactInfo
	// returns the email address
	public String getEmailAddress(){
		return this.email;
	}

}