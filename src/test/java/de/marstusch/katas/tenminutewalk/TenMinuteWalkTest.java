package de.marstusch.katas.tenminutewalk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TenMinuteWalkTest {

   private static final String[] GUELTIGER_WALK_1 = new String[] { "n", "n", "e", "s", "w", "s", "s", "e", "n", "w" };
   private static final String[] UNGUELTIGER_WALK_1 = new String[] { "n", "n", "e", "s", "w", "s", "s", "e", "n", "e" };
   private static final String[] GUELTIGER_WALK_NUR_NS = new String[] { "n", "n", "n", "n", "n", "s", "s", "s", "s", "s" };
   TenMinuteWalk tenMinuteWalk;

   @Before
   public void initTest() {
      this.tenMinuteWalk = new TenMinuteWalk();
   }

   @Test
   public void erwarteFalseWennNull() {
      Assert.assertFalse(this.tenMinuteWalk.walkTenMinutes(null));
   }

   @Test
   public void erwarteFalseWennLEER() {
      Assert.assertFalse(this.tenMinuteWalk.walkTenMinutes(new String[] {}));
   }

   @Test
   public void erwarteFalseWennMehrAlsZehnParameter() {
      String[] steps = new String[] { "n", "n", "n", "n", "n", "n", "n", "n", "n", "n", "n" };
      Assert.assertFalse(this.tenMinuteWalk.walkTenMinutes(steps));
   }

   @Test
   public void erwarteFalseWennWenigerAlsZehnParameter() {
      String[] steps = new String[] { "n" };
      Assert.assertFalse(this.tenMinuteWalk.walkTenMinutes(steps));
   }

   @Test(expected = IllegalArgumentException.class)
   public void erwarteIAEfuerAbf() throws Exception {
      this.tenMinuteWalk.walkTenMinutes(new String[] { "a", "b", "f" });
   }

   @Test(expected = IllegalArgumentException.class)
   public void erwarteIAEfuerUngueltigeRichtung() throws Exception {
      this.tenMinuteWalk.walkTenMinutes(new String[] { "ne" });
   }

   @Test
   public void erwarteTrueFuerKorrektenWalk() {
      Assert.assertTrue(this.tenMinuteWalk.walkTenMinutes(GUELTIGER_WALK_NUR_NS));
   }

   @Test
   public void erwarteFalseWennWalkNichtAmAusgangspunktEndet() throws Exception {
      Assert.assertFalse(this.tenMinuteWalk.walkTenMinutes(UNGUELTIGER_WALK_1));
   }

}
