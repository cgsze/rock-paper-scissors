import java.util.Random;
import java.util.Scanner;

/**
 * This class simulates Rock Paper Scissors
 * @author cgsze
 *
 */
public class RPS {
  
  public static void main(String[] args) {
    // generate computer's choice
    String computer = ""; // computer's RPS choice
    Random rng = new Random(); // randomly generate number 0-2
    int gen = rng.nextInt(3);
    boolean guaranteeWin = false;
    boolean lizardSpock = false;
    
    // Each randomly generated number corresponds to an RPS choice
    if (gen == 0) {
      computer = "ROCK";
    } else if (gen == 1) {
      computer = "SCISSORS";
    } else if (gen == 2) {
      computer = "PAPER";
    }
  
    // start the game
    Scanner in = new Scanner(System.in); // prompt user for input
    
    System.out.println("Configure your settings:");
    System.out.println("(1) Regular Game / (2) RPSLS (under construction)");
    String user = in.nextLine();
    System.out.println("(3) Regular Odds / (4) Guaranteed Win");
    user = in.nextLine();
    if (user.equals("4")) { guaranteeWin = true; }
    
    System.out.println("Settings Done. Game Begin\n");
    
    while (!user.toUpperCase().equals("EXIT")) {
      System.out.println("Make your choice:\nROCK / PAPER / SCISSORS / EXIT");
      user = in.nextLine();
      if (user.toUpperCase().equals("EXIT")) { break; }
      
      if (guaranteeWin) {
        computer = guaranteedWin(user);
      } 
      System.out.println("Computer says: " + computer);
      playGame(user, computer);
      System.out.println();
      
    }//end of while loop
    
  }//end of main method
  
  /**
   * Helper method to return a choice that guarantees 
   * the user will win in a game of RPS
   * @param choice: user's input choice
   * @return losing choice
   */
  protected static String guaranteedWin(String choice) {
    String lose = "";//the computer returns a losing choice so user wins
    
    if (choice.toUpperCase().equals("ROCK")) {
      lose = "SCISSORS";
    } else if (choice.toUpperCase().equals("PAPER")) {
      lose = "ROCK";
    } else if (choice.toUpperCase().equals("SCISSORS")) {
      lose = "PAPER";
    }
    
    return lose;
  }//end of helper method
  
  /**
   * This helper method returns whether the user has won the game or not
   * @param choice: user's input choice
   * @param computer: computer's choice
   */
  protected static void playGame(String choice, String computer) {
    
    if (choice.toUpperCase().equals(computer.toUpperCase())) {
      System.out.println("Tie");
    }
    else {
      boolean win = determineWin(choice, computer);
      if (win) { System.out.println("You win!"); }
      else if (!win) { System.out.println("You lost!"); }
    }
  }//end of helper method
  
  /**
   * This helper method lets us know if the user's choice beats
   * the computer's choice, assuming that a tie is not possible
   * @param choice: user's input
   * @param computer: computer's choice
   * @return true if user beats computer, else false
   */
  public static boolean determineWin(String choice, String computer) {
    boolean won = false;
    
    if (choice.toUpperCase().equals("ROCK")) {
      if (computer.toUpperCase().equals("SCISSORS")) {
        won = true;
      }
    } else if (choice.toUpperCase().equals("PAPER")) {
      if (computer.toUpperCase().equals("ROCK")) {
        won = true;
      }
    } else if (choice.toUpperCase().equals("SCISSORS")) {
      if (computer.toUpperCase().equals("PAPER")) {
        won = true;
      }
    } else {
      System.out.println("Invalid input");
    }
    
    return won;
  }//end of helper method
  
}//end of class
