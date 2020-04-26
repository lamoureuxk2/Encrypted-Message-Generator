package emailGeneration;

import org.apache.log4j.Logger;

import customer.*;

import java.io.BufferedInputStream;
import java.util.Scanner;
import emailQuality.SpellChecker;
import encryption.Encryption;


public class Main {

  private static Scanner input = new Scanner(new BufferedInputStream(System.in));

  /**
   * A main method to run example
   *
   * @param args not used
   */
  public static void main(String[] args) {
	  
	 EmailGenerationSystem gen = new EmailGenerationSystem();
	  
	 //get customer, body, and sender from user
	 Customer customer = null;
	 System.out.println("What Customer are you emailing?\nBusiness, Frequent, New, Returning, VIP?");
	 String choice = input.nextLine();
	 customer = chooseCustomer(choice);
	 System.out.println("What is your name?");
	 String senderName = input.nextLine();
	 System.out.println("Type your message, for new lines, press enter. Press enter twice to finish.");
	 String body = readMultipleLinesFromUser();
	 
	 //run body through spellcheck
	 body = spellCheck(body);
	 
	 String email = gen.generateEmail(customer, body, senderName);
	 
	 
	 System.out.println("Current email:\n" + email + "\n");
	 System.out.println("Do you wish to encrypt? y/n");
	 input.reset();
	 choice = input.nextLine();
	 
	 //final email, whether it ends up encrypted or not, is the final message that is ready to send
	 byte[] finalEmail = null;
	 
	 //Choose to encrypt or not
	 if(choice.equals("y")) {
		 finalEmail = Encryption.EncryptString(email);
		 System.out.println("Email has been encrypted");
	 }
	 else {
		 finalEmail = email.getBytes();
	 }
	 
	 System.out.println("Email is ready for sending");
	 input.close();
  }//end of main
  
  /**
   * return instance of customer subclass based on choice
   * @param choice type of customer
   * @return
   */
  public static Customer chooseCustomer(String choice) {
	  	 if(choice.equals("Business")) {
			 return new BusinessCustomer();
		 }
		 else if(choice.equals("Frequent")) {
			 return new FrequentCustomer();
		 }
		 else if(choice.equals("VIP")) {
			 return new VIPcustomer();
		 }
		 else if(choice.equals("Returning")) {
			 return new ReturningCustomer();
		 }
		 else if(choice.equals("New")) {
			 return new NewCustomer();
		 }
		 else {
			 return new BusinessCustomer();
		 }
  }
  
  /**
   * If there are spelling mistakes, user has choice of editing the string.
   * @param string to spell check
   * @return
   */
  public static String spellCheck(String string) {
	  
	  System.out.println("SpellChecking...");
	  if(!SpellChecker.isSpellChecked(string)) {
		  SpellChecker.spellCheck(string);
		  System.out.println("Do you wish to edit? y/n");
		  input.reset();
		  String choice = input.nextLine();
		  if(choice.equals("y")) {
			  System.out.println("Current message:\n" + string + "\nType new message below");
			  string = readMultipleLinesFromUser();
			  return spellCheck(string);
		  }
		  else return string;
	  }
	  else {
		  System.out.println("No spelling mistakes.");
		  return string;
	  }
  }
  
  private static String readMultipleLinesFromUser() {
	  String string = input.nextLine();
	  while(input.hasNextLine()) {
			 String line = input.nextLine();
			 if(line.isBlank()) break;
			 string += "\n" + line;
	  }
	  return string;
  }
  

}
