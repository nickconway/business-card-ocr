package dev.conway.businesscardparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BusinessCard implements BusinessCardParser {

	// Class members
	ContactInfo contact;

	// Constructor: BusinessCard()
	// Takes a string, the document, and creates the business card
	BusinessCard(){

		try{

			System.out.print("Enter the name of the file to read from: ");
			Scanner inputScanner = new Scanner(System.in);
			String input = inputScanner.nextLine();
			inputScanner.close();

			String path = "data\\" + input;
			System.out.println("Reading from '" + path + "'");

			File info = new File(path);

			String document = "";
			Scanner fileInput = new Scanner(info);
			while(fileInput.hasNextLine()){
				document += fileInput.nextLine() + "\n";
			}
			fileInput.close();

			this.contact = getContactInfo(document);

		} catch(FileNotFoundException error){

			System.out.println("Error: File not found, make sure the file is in the data directory and check the name of the file.");
			error.printStackTrace();

		}

	}

	// Returns the card's contact member
	public ContactInfo getContact(){

		return this.contact;

	}

	// Implementation of the getContactInfo() method in BusinessCardParser
	public ContactInfo getContactInfo(String document){

		// Necessary variables
		String name = "";
		String phone = "";
		String email = "";

		// Check each line for matches
		for(String line: document.split("\\r?\\n")){

			if(name.equals("") && isName(line)){
				String regex = "^( (Mr\\.\\s) | (Mrs\\.\\s) | (Ms\\.\\s) | (Dr\\.\\s) )?";
				String formattedRegex = regex.replaceAll(" ", "");
				line = line.replaceAll(formattedRegex, "");
				name = line;
			} else if(phone.equals("") && isPhone(line)){
				phone = line.replaceAll("\\D", "");
			} else if(email.equals("") && isEmail(line)){
				email = line;
			}

		}

		// Create the contact
		Contact contact = new Contact(name, phone, email);
		return contact;

	}

	// Returns formatted string for outputting to the user
	@Override
	public String toString(){

		return "Name: " + this.contact.getName() + "\n"
			+ "Phone: " + this.contact.getPhoneNumber() + "\n"
			+ "Email: " + this.contact.getEmailAddress();

	}

	// Checks the list of names to see if the line contains one
	private boolean isName(String line){

		try{

			String regex = "^( (Mr\\.\\s) | (Mrs\\.\\s) | (Ms\\.\\s) | (Dr\\.\\s) )?";
			String formattedRegex = regex.replaceAll(" ", "");
			line = line.replaceAll(formattedRegex, "");

			String firstWord = line.split(" ")[0];
			List<String> firstNames = Files.readAllLines(Paths.get("data\\first_names.txt"));

			return Collections.binarySearch(firstNames, firstWord) > 0 ? true : false;

		} catch(IOException e){

			e.printStackTrace();
			return false;

		}

	}

	// Checks to see if the line is a valid phone number
	private boolean isPhone(String line){

		if(line.contains("Fax")){
			return false;
		}

		String regex = "^ .* (\\+1)? \\s* (\\(? \\d{3} \\)? -)+ \\d{4} $";
		String formattedRegex = regex.replaceAll(" ", "");

		return line.matches(formattedRegex) ? true : false;

	}

	// Checks to see if the line is a valid email address
	private boolean isEmail(String line){

		String regex = "^ (\\w | \\.)+ @ \\w+ \\. \\w+ $";
		String formattedRegex = regex.replaceAll(" ", "");

		return line.matches(formattedRegex) ? true : false;

	}

}