/*
* This class is a playing card.
*
* @author  Jacob Bonner
* @version 1.0
* @since   2021-01-18
*/

/**
 * This class creates an object that acts like a playing card.
 */
public class PlayingCard {
  // Initializing fields
  private String cardFace;
  private String cardSuit;
  private int cardValue;

  /**
   * Setting field values with a constructor.
   */
  public PlayingCard(String cardIdentity) {
    this.cardFace = cardIdentity;
    this.cardSuit = setSuit(cardFace);
    this.cardValue = setValue(cardFace);
  }

  /**
   * This method finds the suit of the card.
   */
  private String setSuit(String cardImage) {
    // Finding the suit of the card
    String suit = cardImage.substring(cardImage.length() - 1);

    // Setting the card's suit as the suit found
    return suit;
  }

  /**
   * This method finds the value of the card.
   */
  private int setValue(String cardPicture) {
    // Determining the first character to help with finding the value
    char cardNumber = cardPicture.charAt(0);

    // If statement that determines the value of the card
    if (cardNumber == '2') {
      // Returning the card value as 2
      return 2;

    } else if (cardNumber == '3') {
      // Returning the card value as 3
      return 3;

    } else if (cardNumber == '4') {
      // Returning the card value as 4
      return 4;

    } else if (cardNumber == '5') {
      // Returning the card value as 5
      return 5;

    } else if (cardNumber == '6') {
      // Returning the card value as 6
      return 6;

    } else if (cardNumber == '7') {
      // Returning the card value as 7
      return 7;

    } else if (cardNumber == '8') {
      // Returning the card value as 8
      return 8;

    } else if (cardNumber == '9') {
      // Returning the card value as 9
      return 9;

    } else if (cardNumber == '1' || cardNumber == 'J' || cardNumber == 'Q'
               || cardNumber == 'K') {
      // Returning the value of 10 based on the 10 and face cards
      return 10;

    } else if (cardNumber == 'A') {
      // Returning the card value as 11 based on an ace
      return 11;

    } else {
      // Returning -1 to show that an error occurred
      return -1;
    }
  }

  /**
   * This getter shows the user the card face.
   */
  public String getCardFace() {
    // Returning the card face to the user
    return this.cardFace;
  }

  /**
   * This getter shows the user the card value.
   */
  public int getCardValue() {
    // Returning the card value to the user
    return this.cardValue;
  }

  /**
   * This getter shows the suit of the card.
   */
  public String getCardSuit() {
    return this.cardSuit;
  }
}
