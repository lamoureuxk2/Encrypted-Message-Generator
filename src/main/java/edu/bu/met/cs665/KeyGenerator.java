package edu.bu.met.cs665;

import java.io.*;
import java.security.*;

public class KeyGenerator {
	
	private static final String PUBLIC_KEY_FILENAME = "publickey.txt";
	private static final String PRIVATE_KEY_FILENAME = "privatekey.txt";
	
	public static void main(String[] args) {
		
		//Creating KeyPair generator object
		KeyPairGenerator keyPairGen = null;
		try {
			keyPairGen = KeyPairGenerator.getInstance("DSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
				
		//Initializing the KeyPairGenerator
		keyPairGen.initialize(2048);
		
		//Generate the pair of keys
		KeyPair pair = keyPairGen.generateKeyPair();
		
		//Getting the public key from the key pair
		PublicKey publicKey = pair.getPublic();
		
		//Getting the private key from the key pair
		PrivateKey privateKey = pair.getPrivate();
		
		FileOutputStream file;
		ObjectOutputStream out;
		try {
			file = new FileOutputStream(PUBLIC_KEY_FILENAME);
			out = new ObjectOutputStream(file);
			
			// Method for serialization of object 
	        out.writeObject(publicKey); 
	        out.close();
	        file.close();
	        
	        file = new FileOutputStream(PRIVATE_KEY_FILENAME);
			out = new ObjectOutputStream(file);
			
			// Method for serialization of object 
	        out.writeObject(privateKey); 
	        out.close();
	        file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
        
	}

}
