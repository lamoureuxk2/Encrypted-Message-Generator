package encryption;

import java.security.*;
import javax.crypto.*;
import java.io.*;

/**
 * Contains a method for encrypting a string into a byte[] and 
 * decrypting a byte[] back to a string.
 * This class depends on the keys created by KeyGenerator.main()
 * 
 * The main() in this class just tests the methods.
 * 
 * Much code was directly used from tutorial on java encryption 
 * https://www.tutorialspoint.com/java_cryptography/java_cryptography_decrypting_data.htm
 * @author lamoureuxk
 *
 */
public class Encryption {
	
	private static final String PRIVATE_KEY_FILENAME = "privatekey.key";
	private static final String PUBLIC_KEY_FILENAME = "publickey.key";
	
	
	public static byte[] EncryptString(String string) {
		
		try{
			//Creating a Cipher object
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			
			PublicKey publicKey = null;
			
			//reading key from file
			// Reading the object from a file 
            FileInputStream file = new FileInputStream(PUBLIC_KEY_FILENAME); 
            ObjectInputStream in = new ObjectInputStream(file); 
			publicKey = (PublicKey)(in.readObject());
			
			//Initializing a Cipher object
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			
			//Adding data to the cipher
			byte[] msg = string.getBytes();
			cipher.update(msg);
			
			//Encrypting the data
			byte[] cipherText = cipher.doFinal();
			
			//close streams
			in.close();
			file.close();
			
			return cipherText;
			
		} catch (InvalidKeyException 
				| IOException | ClassNotFoundException | 
				IllegalBlockSizeException | BadPaddingException
				| NoSuchAlgorithmException | NoSuchPaddingException e) 
		{
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
	
	public static String DecryptByteArray(byte[] msg) {
		try{
			//Creating a Cipher object
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			
			PrivateKey privateKey = null;
			
			//reading key from file
			// Reading the object from a file 
            FileInputStream file = new FileInputStream(PRIVATE_KEY_FILENAME); 
            ObjectInputStream in = new ObjectInputStream(file); 
			privateKey = (PrivateKey)(in.readObject());
			
			//close streams
			in.close();
			file.close();
			
			//Initializing a Cipher object
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			
			//Decrypting the data
			byte[] decryptedByteArray = cipher.doFinal(msg);
			
			return new String(decryptedByteArray);
			
		} catch (InvalidKeyException 
				| IOException | ClassNotFoundException | 
				IllegalBlockSizeException | BadPaddingException
				| NoSuchAlgorithmException | NoSuchPaddingException e) 
		{
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}

	/**
	 * This tests the encrypting and decrypting methods in this class
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws KeyStoreException
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, KeyStoreException {
		
		String original = "Hello, pls encypt UwU";
		byte[] encrypted = EncryptString(original);
		System.out.println("Encrypted bytes: " + encrypted.toString());
		System.out.println("Decrypted String: " + DecryptByteArray(encrypted));

	}
	
	

}
