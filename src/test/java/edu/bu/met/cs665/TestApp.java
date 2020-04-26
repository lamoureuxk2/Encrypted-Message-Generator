package edu.bu.met.cs665;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import encryption.Encryption;
import emailQuality.SpellChecker;
import customer.*;
import emailGeneration.EmailGenerationSystem;

public class TestApp {
	
	private static EmailGenerationSystem gen;
	private static final String EXAMPLE_BODY = "This is an example body.\nThis tests email generation.";
	private static final String EXAMPLE_NAME = "Example Sender";
	
	@Before
	public void initialize() {
		gen = new EmailGenerationSystem();
	}
	
	@Test
	public void testVIPEmailGeneration() {
		Customer vip = new VIPcustomer();
		String email = gen.generateEmail(vip, EXAMPLE_BODY, EXAMPLE_NAME);
		assertTrue(email.contains(gen.VIP_HEADER));
		assertTrue(email.contains(gen.VIP_FOOTER + EXAMPLE_NAME));
		assertTrue(email.contains(EXAMPLE_BODY));
	}
	
	@Test
	public void testFrequentEmailGeneration() {
		Customer Frequent = new FrequentCustomer();
		String email = gen.generateEmail(Frequent, EXAMPLE_BODY, EXAMPLE_NAME);
		assertTrue(email.contains(gen.FREQUENT_HEADER));
		assertTrue(email.contains(gen.FREQUENT_FOOTER + EXAMPLE_NAME));
		assertTrue(email.contains(EXAMPLE_BODY));
	}
	
	@Test
	public void testBusinessEmailGeneration() {
		Customer Business = new BusinessCustomer();
		String email = gen.generateEmail(Business, EXAMPLE_BODY, EXAMPLE_NAME);
		assertTrue(email.contains(gen.BUSINESS_HEADER));
		assertTrue(email.contains(gen.BUSINESS_FOOTER + EXAMPLE_NAME));
		assertTrue(email.contains(EXAMPLE_BODY));
	}
	
	@Test
	public void testNewEmailGeneration() {
		Customer New = new NewCustomer();
		String email = gen.generateEmail(New, EXAMPLE_BODY, EXAMPLE_NAME);
		assertTrue(email.contains(gen.NEW_HEADER));
		assertTrue(email.contains(gen.NEW_FOOTER + EXAMPLE_NAME));
		assertTrue(email.contains(EXAMPLE_BODY));
	}
	
	@Test
	public void testReturningEmailGeneration() {
		Customer Returning = new ReturningCustomer();
		String email = gen.generateEmail(Returning, EXAMPLE_BODY, EXAMPLE_NAME);
		assertTrue(email.contains(gen.RETURNING_HEADER));
		assertTrue(email.contains(gen.RETURNING_FOOTER + EXAMPLE_NAME));
		assertTrue(email.contains(EXAMPLE_BODY));
	}
	
	@Test
	public void testSpellCheck() {
		String correctString = "This is a correct String.\nThis should pass spell check.";
		String incorrectString = "tihs is an icnorect Stwing.\nNo pas tset.";
		
		assertTrue(SpellChecker.isSpellChecked(correctString));
		assertFalse(SpellChecker.isSpellChecked(incorrectString));
	}

	@Test
	public void testEncryptingStrings() {
		String string = "Hello\nThis is an example String to encrypt\nI hope this test works";
		byte[] encrypted = Encryption.EncryptString(string);
		assertFalse(string.equals(new String(encrypted)));
		String decrypted = Encryption.DecryptByteArray(encrypted);
		assertTrue(string.equals(decrypted));
	}

}
