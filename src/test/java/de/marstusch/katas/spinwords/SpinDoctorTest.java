package de.marstusch.katas.spinwords;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpinDoctorTest {

   @Test
   public void should_spin_the_scentence() throws Exception {
      assertEquals("sellA Gute zum gatstrubeG", new SpinDoctor().spinWords("Alles Gute zum Geburtstag"));
      assertEquals("sellA   Gute", new SpinDoctor().spinWords("Alles   Gute"));
      assertEquals(" sellA   Gute", new SpinDoctor().spinWords(" Alles   Gute"));
   }

   @Test
   public void should_spindWords_notSpinWordWhenWordIsLess5() throws Exception {
      assertEquals("Boom", new SpinDoctor().spinWordWhenNecessary("Boom"));
   }

   @Test
   public void should_spinWordWhenWordIsLonger4() throws Exception {
      assertEquals("ajooB", new SpinDoctor().spinWordWhenNecessary("Booja"));
   }

   @Test(expected = IllegalArgumentException.class)
   public void should_throw_exception_when_not_a_letter() throws Exception {
      new SpinDoctor().validate("!Bam !");
   }
}
