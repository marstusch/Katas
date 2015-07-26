package de.marstusch.katas.spinwords;

import java.util.regex.Pattern;

public class SpinDoctor {

   public String spinWords(String input) {
      validate(input);

      String[] words = input.split(" ");

      String phrase = "";
      for (int i = 0; i < words.length; i++) {
         phrase += spinWordWhenNecessary(words[i]);
         if (i < words.length - 1) {
            phrase += " ";
         }
      }
      return phrase;
   }

   String spinWordWhenNecessary(String word) {
      return (word.length() > 4) ? spinWord(word) : word;
   }

   String spinWord(String word) {
      String spinnedWord = "";
      for (int i = word.length() - 1; i >= 0; i--) {
         spinnedWord += word.charAt(i);
      }
      return spinnedWord;
   }

   void validate(String string) {
      Pattern p = Pattern.compile("[^\\w\\s]+");
      if (p.matcher(string).find())
         throw new IllegalArgumentException();
   }
}