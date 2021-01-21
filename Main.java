/*
* This program is a game of Black Jack for the Java console on AWS Cloud9.
*
* @author  Jacob Bonner
* @version 1.0
* @since   2021-01-18
*/

import java.util.Scanner;  // Import the Scanner class

/**
 * This class makes use of objects to create a game of black jack.
 */
public class Main {
  /**
   * This function clears the screen.
   */
  static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  static void helpScreen() {
    // Creating a scanner to receive the input to end the help screen
    final Scanner helpInput = new Scanner(System.in);

    // Clearing the screen
    clearScreen();

    // Printing text that helps the player understand how the game works
    System.out.println("Rules:");
    System.out.println("-Your goal: get more points than the dealer without "
                       + "going over 21!");
    System.out.println("-Maximum 6 cards each");
    System.out.println("-Type 'Hit' for another card");
    System.out.println("-Type 'Stand' to end your turn and put your hand "
                       + "against the dealer's");
    System.out.println("-Type 'CashOut' to quit early with the money you have");
    System.out.println("-Aces can be worth 1 or 11 depending on when they are "
                       + "dealt");
    System.out.println("-Face cards are all worth 10");
    System.out.println("-You start with $50 and play until you have $0 or cash "
                       + "out");
    System.out.println("-You gain $10 for a win and lose $10 for a loss");
    System.out.println("-Good luck, have fun!");
    System.out.println("");
    System.out.flush();

    // Receiving user input about ending help screen
    System.out.print("Press ‘ENTER’ when you wish to continue playing: ");
    String endHelpInput = helpInput.nextLine();
  }

  /**
   * This function deals cards to the two players.
   */
  static CardHand[] dealCards(DeckOfCards cardDeck) {
    // Instantiating card hands for each player
    CardHand userCardHand = new CardHand();
    CardHand cpuCardHand = new CardHand();

    // Drawing the first two cards for the player's and dealer's hand
    PlayingCard userCard1 = new PlayingCard(cardDeck.drawCard(), 0);
    userCardHand.addCard(userCard1);
    PlayingCard cpuCard1 = new PlayingCard(cardDeck.drawCard(), 0);
    cpuCardHand.addCard(cpuCard1);

    // Drawing the second two cards for the player's and dealer's hand
    PlayingCard userCard2 = new PlayingCard(cardDeck.drawCard(),
                                            userCardHand.getHandValue());
    userCardHand.addCard(userCard2);
    PlayingCard cpuCard2 = new PlayingCard(cardDeck.drawCard(),
                                           userCardHand.getHandValue());
    cpuCardHand.addCard(cpuCard2);

    // Creating a list to return each hand from the function
    CardHand[] handList = new CardHand[2];

    // Adding the hands to an array to pass out of this function
    handList[0] = userCardHand;
    handList[1] = cpuCardHand;

    // Returning the list with the hands
    return handList;
  }

  /**
   * This function runs a game of black jack.
   */
  public static void main(String[] args) {
    try {
      // Creating scanners to accept the starting user input
      final Scanner beginInput = new Scanner(System.in);
      final Scanner gameInput = new Scanner(System.in);

      // Printing title text
      System.out.println("♠♥♦♣ Welcome to Black Jack! ♣♦♥♠");
      System.out.println("");

      // Input that starts the game
      System.out.print("Press 'ENTER' to Play: ");
      String startInput = beginInput.nextLine();
      System.out.println("");
      System.out.println("");

      // Instantiating a deck of cards
      DeckOfCards deck = new DeckOfCards();

      // Dealing each player a hand of cards
      CardHand[] handInfo = dealCards(deck);
      CardHand playerHand = handInfo[0];
      CardHand dealerHand = handInfo[1];

      // Clearing the screen
      clearScreen();

      // Setting up the player's initial monetary amount
      int playerMoney = 50;

      // Game loop
      while (true) {
        // Printing info about the dealer's hand and the card deck
        System.out.print("Dealer's Hand");
        System.out.print("       Total: " + dealerHand.showCardValue(1));
        System.out.println("       Cards in Deck: " + deck.numberOfCards());

        // Printing the hand of the dealer
        System.out.println("?? | " + dealerHand.showCardFace(1));
        System.out.println("");

        // Printing info about the player's hand and how much money they have
        System.out.print("Player's Hand");
        System.out.print("       Total: " + playerHand.getHandValue());
        System.out.println("       Money: $" + playerMoney);

        // Printing the hand of the player
        for (int playerCounter = 0; playerCounter < playerHand.amountOfCards();
             playerCounter++) {
          System.out.print(playerHand.showCardFace(playerCounter));
          if (playerCounter == playerHand.amountOfCards() - 1) {
            continue;
          } else {
            System.out.print(" | ");
          }
        }
        System.out.println("");
        System.out.println("");

        // Receiving input for the move the player would like to make
        System.out.print("What would you like to do "
                         + "(Hit/Stand/Help/CashOut): ");
        String userInputLowerCase = gameInput.nextLine();
        String userInput = userInputLowerCase.toUpperCase();

        // Checking to see which input was entered
        if (userInput.equals("HELP")) {
          helpScreen();
        }

        // Clearing the screen again
        clearScreen();
      }

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
