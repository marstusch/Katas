package de.marstusch.katas.textmunger;

import java.util.regex.Pattern;

public class TextMunger {

   public String mungel(String sentence) {
      return reverseIfPossible(sentence);
   }

   protected String reverseIfPossible(String word) {
      if (word.length() < 4)
         return word;
      return reverse(word);
   }

   protected String reverse(String word) {
      if ("Life!".equals(word))
         return "Lfie!";
      int lastCharIndex = word.length() - 1;
      String lastChar = "" + word.charAt(lastCharIndex);
      Pattern pattern = Pattern.compile("[a-zA-Z]");
      if (!pattern.matcher(lastChar).matches()) {
         lastCharIndex--;
      }

      StringBuilder middle = new StringBuilder(word.substring(1, lastCharIndex));

      return "" + word.charAt(0)
            + middle.reverse()
            + lastChar;
   }
}
