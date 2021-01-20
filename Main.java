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
    try {
      // Instantiating a test deck and a test card
      DeckOfCards deck = new DeckOfCards();
      String drawn = deck.drawCard();
      PlayingCard card = new PlayingCard(drawn, 0);

      // Instantiating a test hand of cards
      CardHand playerHand = new CardHand();
      playerHand.addCard(card);
      int value = playerHand.getHandValue();

      // Printing information about the test card
      System.out.println("Number of Cards in Deck: " + deck.numberOfCards());
      System.out.println("Card Drawn: " + card.getCardFace());
      System.out.println("Suit of Card Drawn: " + card.getCardSuit());
      System.out.println("Value of Card Drawn: " + card.getCardValue());
      System.out.println("");

      // Printing information about the player's test hand
      System.out.println("Number of Cards in Hand: "
                         + playerHand.amountOfCards());
      System.out.println("Value of Cards: "
                         + playerHand.getHandValue());
      playerHand.emptyHand();

      // Reshuffling the deck
      deck.recallDeck();
      System.out.println("Number of Cards After Shuffling: "
                         + deck.numberOfCards());

      // Catches and tells the user what error occured
    } catch (NullPointerException e) {
      System.out.println("");
      System.out.println("ERROR: Card could not be created");
    } catch (Exception e) {
      System.out.println("");
      System.out.println("ERROR: Invalid Input");
    }
  }
}
