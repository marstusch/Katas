package de.marstusch.katas.cardsgame;

public class Cardsgame {

   public enum PictureCard {
      A(14), K(13), Q(12), J(11), T(10);

      private int pictureValue;

      private PictureCard(int pictureValue) {
         this.pictureValue = pictureValue;
      }

      public int pictureValue() {
         return pictureValue;
      }

      public static int pictureValueFrom(char card) {
         switch (card) {
         case 'A':
            return PictureCard.A.pictureValue;
         case 'K':
            return PictureCard.K.pictureValue;
         case 'Q':
            return PictureCard.Q.pictureValue;
         case 'J':
            return PictureCard.J.pictureValue;
         case 'T':
            return PictureCard.T.pictureValue;
         }
         return card;
      }

      public static boolean isPictureCard(char card) {
         char[] pictureCards = { 'A', 'K', 'Q', 'J', 'T' };
         if (String.valueOf(pictureCards).contains(String.valueOf(card))) {
            return true;
         }
         return false;
      }
   }

   private int player1Score;
   private int player2Score;

   public String determineGameResult(char[] cardsOfPlayer1, char[] cardsOfPlayer2) {
      for (int i = 0; i < cardsOfPlayer1.length; i++) {
         if (cardValue(cardsOfPlayer1[i]) > cardValue(cardsOfPlayer2[i])) {
            player1Score++;
         } else if (cardValue(cardsOfPlayer2[i]) > cardValue(cardsOfPlayer1[i])) {
            player2Score++;
         }
      }

      return gameResultMessage();
   }

   private int cardValue(char card) {
      boolean pictureCard = PictureCard.isPictureCard(card);
      return pictureCard ? PictureCard.pictureValueFrom(card) : convertToInt(card);
   }

   private Integer convertToInt(char card) {
      return Integer.valueOf(String.valueOf(card));
   }

   private String gameResultMessage() {
      if (player1Score > player2Score) {
         return String.format("Player1 wins %s to %s", player1Score, player2Score);
      } else if (player2Score > player1Score){
         return String.format("Player2 wins %s to %s", player2Score, player1Score);
      } else {
         return "Tie";
      }
   }

}
