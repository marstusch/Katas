package de.marstusch.katas.caffeinescript;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCaffeineScript {
   private static final CaffeineScript CAFFEINE_SCRIPT = new CaffeineScript();

   @Test(expected = IllegalArgumentException.class)
   public void
   should_throw_exception_when_number_is_zero() throws Exception {
      CAFFEINE_SCRIPT.caffeineBuzz(0);
   }

   @Test
   public void
   should_return_mocha_missing_when_number_is_not_div_3_and_4() throws Exception {
      String returnValue = CAFFEINE_SCRIPT.caffeineBuzz(7);
      assertEquals("mocha_missing", returnValue);
      returnValue = CAFFEINE_SCRIPT.caffeineBuzz(28);
      assertEquals("mocha_missing", returnValue);
   }

   @Test
   public void
   should_return_java_when_number_is_div_by_3() throws Exception {
      String returnValue = CAFFEINE_SCRIPT.caffeineBuzz(3);
      assertEquals("Java", returnValue);
   }

   @Test
   public void
   should_return_javascript_when_number_is_div_by_3_and_is_even() throws Exception {
      String returnValue = CAFFEINE_SCRIPT.caffeineBuzz(6);
      assertEquals("JavaScript", returnValue);
   }

   @Test public void
   should_return_coffeescript_when_number_is_div_by_3_and_4() throws Exception {
      String returnValue = CAFFEINE_SCRIPT.caffeineBuzz(12);
      assertEquals("CoffeeScript", returnValue);
   }

}
