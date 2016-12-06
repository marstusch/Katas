package de.marstusch.katas.cardsgame;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import de.marstusch.katas.cardsgame.Cardsgame;

public class CardsgameTest {

   private Cardsgame cardsgame;

   @Before
   public void initTest() {
      cardsgame = new Cardsgame();
   }

   @Test
   public void returns_winning_player2_when_player2_has_one_number_highcard() throws Exception {
      String message = cardsgame.determineGameResult(new char[] { '2' }, new char[] { '3' });
      assertThat(message, is("Player2 wins 1 to 0"));
   }

   @Test
   public void returns_winning_player1_when_player1_has_one_number_highcard() throws Exception {
      String message = cardsgame.determineGameResult(new char[] { '5' }, new char[] { '4' });
      assertThatPlayer1Wins1To0(message);
   }

   @Test
   public void returns_winning_player1_when_player1_has_two_number_highcards() throws Exception {
      String message = cardsgame.determineGameResult(new char[] { '3', '9', '2' }, new char[] { '2', '8', '3' });
      assertThat(message, is("Player1 wins 2 to 1"));
   }
   
   @Test
   public void returns_tie_when_both_players_have_same_quantity_of_number_highcards() throws Exception {
      String message = cardsgame.determineGameResult(new char[] { '6', '9' }, new char[] { '7', '8' });
      assertThat(message, is("Tie"));
   }

   @Test
   public void returns_winning_player1_by_ace_over_king() throws Exception {
      String message = cardsgame.determineGameResult(new char[] { 'A' }, new char[] { 'K' });
      assertThatPlayer1Wins1To0(message);
   }

   @Test
   public void returns_winning_player1_by_king_over_queen() throws Exception {
      String message = cardsgame.determineGameResult(new char[] { 'K' }, new char[] { 'Q' });
      assertThatPlayer1Wins1To0(message);
   }

   @Test
   public void returns_winning_player1_by_queen_over_jack() throws Exception {
      String message = cardsgame.determineGameResult(new char[] { 'Q' }, new char[] { 'J' });
      assertThatPlayer1Wins1To0(message);
   }
   
   @Test
   public void returns_winning_player1_by_jack_over_ten() throws Exception {
      String message = cardsgame.determineGameResult(new char[] { 'J' }, new char[] { 'T' });
      assertThatPlayer1Wins1To0(message);
   }

   @Test
   public void returns_winning_player1_by_ten_over_nine() throws Exception {
      String message = cardsgame.determineGameResult(new char[] { 'T' }, new char[] { '9' });
      assertThatPlayer1Wins1To0(message);
   }

   private void assertThatPlayer1Wins1To0(String message) {
      assertThat(message, is("Player1 wins 1 to 0"));
   }
}
