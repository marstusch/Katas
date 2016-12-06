package de.marstusch.katas.textmunger;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TextMungerTest {

   private TextMunger textmunger = new TextMunger();

   @Test
   public void gibtWortKleiner4BuchstabenZurueck() throws Exception {
      String mungledWord = textmunger.mungel("for");
      assertThat(mungledWord, is("for"));
   }

   @Test
   public void gibtWortVerdrehtZurueck() throws Exception {
      String mungeldWord = textmunger.mungel("Programming");
      assertThat(mungeldWord, is("Pnimmargorg"));
   }

   @Test
   public void verdrehtKeinSatzzeichen() throws Exception {
      String mungeldWordWithSatzzeichen = textmunger.mungel("Life!");
      assertThat(mungeldWordWithSatzzeichen, is("Lfie!"));
   }
}
