package edu.bu.met.cs665;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.*;


import org.languagetool.*;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.*;

public class Main {

  private static Logger logger = Logger.getLogger(Main.class);


  /**
   * A main method to run examples.
   *
   * @param args not used
   */
  public static void main(String[] args) {
	  
	  JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
	  
	  //Remove this loop to do more than spelling
	  for (Rule rule : langTool.getAllRules()) {
	    if (!rule.isDictionaryBasedSpellingRule()) {
	      langTool.disableRule(rule.getId());
	    }
	  }
	  List<RuleMatch> matches = null;
	try {
		matches = langTool.check("A speling eror");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	  for (RuleMatch match : matches) {
	    System.out.println("Potential typo at characters " +
	        match.getFromPos() + "-" + match.getToPos() + ": " +
	        match.getMessage());
	    System.out.println("Suggested correction(s): " +
	        match.getSuggestedReplacements());
	  }

    // This configuration is for setting up the log4j properties file.
    // It is better to set this using java program arguments.
    // PropertyConfigurator.configure("log4j.properties");

    // Let us create an object of the Main class.
	/*
	 * Main m = new Main();
	 * 
	 * logger.info(m.doIt());
	 * 
	 * logger.trace("Trace Message!"); logger.debug("Debug Message!");
	 * logger.info("Info Message!"); logger.warn("Warn Message!");
	 * logger.error("Error Message!"); logger.fatal("Fatal Message!");
	 */

  }//end of main

}
