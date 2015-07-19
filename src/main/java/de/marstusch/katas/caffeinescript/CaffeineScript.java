package de.marstusch.katas.caffeinescript;

public class CaffeineScript {

   private static final String SCRIPT = "Script";
   private static final String COFFEE = "Coffee";
   private static final String MOCHA_MISSING = "mocha_missing";
   private static final String JAVA = "Java";

   public String caffeineBuzz(int number) {
      if (number == 0) throw new IllegalArgumentException();
      if (number % 3 == 0) {
         String phrase = JAVA;
         if (number % 4 == 0) {
            phrase = COFFEE;
         }
         return (number % 2 == 0) ? phrase += SCRIPT : phrase;
      }

      return MOCHA_MISSING;
   }
}
