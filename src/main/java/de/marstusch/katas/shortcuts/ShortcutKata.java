package de.marstusch.katas.shortcuts;

import java.util.regex.Pattern;

public class ShortcutKata {

	 public String spinWords(String st) {
	      validate(st);

	      String[] s = st.split(" ");

	      String foo = "";
	      for (int i = 0; i < s.length; i++) {
	         String b = spinWordWhenNecessary(s[i]);
			foo += b;
	         if (i < s.length - 1) {
	            foo += " ";
	         }
	      }
	      return foo;
	   }

	   String spinWordWhenNecessary(String word) {
	      if (word.length() > 4) {
	    	  String spinnedWord = "";
		      for (int i = word.length() - 1; i >= 0; i--) {
		         spinnedWord += word.charAt(i);
		      }
		      return spinnedWord;
	      }   
	    	  return word;
	   }

	   

   void validate(String string) {
      Pattern p = Pattern.compile("[^\\w\\s]+");
      if (p.matcher(string).find())
         throw new IllegalArgumentException();
   }	
}
