package test.dev.conway.businesscardparser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import test.dev.conway.businesscardparser.BusinessCard;

public class AppTests {

	BusinessCard noNameCard;
	BusinessCard noEmailCard;
	BusinessCard noPhoneCard;

	@Before
	public void initTests(){

		noNameCard = new BusinessCard("no_name.txt");
		noEmailCard = new BusinessCard("no_email.txt");
		noPhoneCard = new BusinessCard("no_phone.txt");

	}

	@Test
	public void shouldReturnNoneWithNoName(){

		System.out.println(noNameCard.contact.getName());
		assertEquals("", noNameCard.contact.getName());

	}

	@Test
	public void shouldReturnNoneWithNoEmail(){

		System.out.println(noEmailCard.contact.getEmailAddress());
		assertEquals("", noEmailCard.contact.getEmailAddress());

	}

	@Test
	public void shouldReturnNoneWithNoPhone(){

		System.out.println(noPhoneCard.contact.getPhoneNumber());
		assertEquals("", noPhoneCard.contact.getPhoneNumber());

	}

}