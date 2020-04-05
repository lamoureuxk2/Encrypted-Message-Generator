package edu.bu.met.cs665;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import encryption.Encryption;

public class TestApp {
	
	private static EmailGenerationSystem gen;
	
	@Before
	public void initialize() {
		gen = new EmailGenerationSystem();
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
