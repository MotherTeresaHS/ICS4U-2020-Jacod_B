/*
* This program is a game of Black Jack for the Java console on AWS Cloud9.
*
* @author  Jacob Bonner
* @version 1.0
* @since   2021-01-18
*/

/**
 * This class makes use of objects to create a game of black jack.
 */
public class Main {
  /**
   * This function runs a game of black jack.
   */
  public static void main(String[] args) {
    // Instantiating a test deck and two test cards
    DeckOfCards deck = new DeckOfCards();
    String drawn = deck.drawCard();
    PlayingCard card = new PlayingCard(drawn);

    // Printing information about the test card
    System.out.println("Number of Cards: " + deck.numberOfCards());
    System.out.println("Card Drawn: " + card.getCardFace());
    System.out.println("Suit of Card Drawn: " + card.getCardSuit());
    System.out.println("Value of Card Drawn: " + card.getCardValue());
    System.out.println("");
  }
}
