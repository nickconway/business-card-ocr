# Buisness Card OCR

## Overview
The purpose of this program is to read in business card information and isolate the name, email address, and phone number of the contact. This exercise is part of [Asymmetrik's Programming Challenges.](https://asymmetrik.com/programming-challenges/)

## Instructions
Before running the program, make sure the file to be read is placed in the `data` directory as a `.txt` file. When inputting the file name, type ONLY the file name and extension, no directories. To run the program open a terminal and run these commands:

```
$ git clone https://github.com/nickconway/business-card-ocr

$ cd business-card-ocr

$ javac -d bin .\dev\conway\businesscardparser\App.java

$ java -cp bin dev.conway.businesscardparser.App
```

## The Process
Using the provided interfaces, I determined the best way to lay out the programs structure is to have seperate class for each interface.

The structure I decided on was having a BusinessCard class that implements the BusinessCardParser interface, and inside that is a Contact class which implements the ContactInfo interface and has the member variables of the name, email, and phone number.

To get the contact's information, the program checks each line to see if it matches a name, email address, or phone number.

For parsing the name, I figured the best way to go about it without using some sort of language processing was to search for the first name in a list of common first names in the country. This could be an issue if say the company name started with Smith, but this issue could be fixed by also including a list of last names and checking the line for that as well. I also made sure to remove any title at the beginning so it only returns the person's name.

For the email address, I used a regex expression to see if the line matches the standard email format.

For the phone number, I used another regex expression to see if the line matches the U.S. telephone number format, and made sure to ignore fax numbers.

To return all the information, I simply overrode the toString method of the Contact class and formatted it in an easy to read way.