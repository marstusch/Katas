package de.marstusch.katas.tenminutewalk;

public class TenMinuteWalk {

   String valid = "nesw";

   public boolean walkTenMinutes(String[] steps) {
      validate(steps);

      if (steps == null || steps.length != 10)
         return false;

      for (String step : steps) {
         Richtung.pruefe(step);
      }


      return false;
   }

   protected void validate(String[] steps) {
      if (steps != null) {
         for (String step : steps) {
            if (Richtung.pruefe(step) == null)
               throw new IllegalArgumentException();
         }
      }
   }

   public enum Richtung {
      NORTH("n", 1),

      SOUTH("s", -1),

      EAST("e", 0),

      WEST("w", 0);

      private String key;
      private int nordsued;

      private Richtung(String key, int nordsued) {
         this.key = key;
         this.nordsued = nordsued;
      }

      public String getKey() {
         return this.key;
      }

      public static Richtung pruefe(String abkuerzung) {
         for (Richtung r : Richtung.values()) {
            if (r.getKey().equals(abkuerzung.toLowerCase()))
               return r;
         }
         return null;
      }

   }

}
