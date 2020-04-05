package emailQuality;

import java.io.IOException;
import java.util.List;

import org.languagetool.*;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.*;

/**
 * Code uses library found at http://wiki.languagetool.org/java-spell-checker
 * Also the code to use this library for spell checking is taken from that page
 */
public class SpellChecker {
	
	public static boolean isSpellChecked(String string) {
		JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
		  
		  //Remove this loop to do more than spelling
		  for (Rule rule : langTool.getAllRules()) {
		    if (!rule.isDictionaryBasedSpellingRule()) {
		      langTool.disableRule(rule.getId());
		    }
		  }
		  List<RuleMatch> matches = null;
		try {
			matches = langTool.check(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		  
		  if(matches == null || matches.isEmpty()) {
			  return true;
		  }
		  else return false;
	}
	
	public static void spellCheck(String string) {
		JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
		  
		  //Remove this loop to do more than spelling
		  for (Rule rule : langTool.getAllRules()) {
		    if (!rule.isDictionaryBasedSpellingRule()) {
		      langTool.disableRule(rule.getId());
		    }
		  }
		  List<RuleMatch> matches = null;
		try {
			matches = langTool.check(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		  for (RuleMatch match : matches) {
		    System.out.println("Potential typo at characters " +
		        match.getFromPos() + "-" + match.getToPos() + ": " +
		        match.getMessage());
		    System.out.println("Suggested correction(s): " +
		        match.getSuggestedReplacements());
		    
		  }
		  if(matches == null || matches.isEmpty()) {
			  System.out.println("No mistakes found");
		  }
	}

}
