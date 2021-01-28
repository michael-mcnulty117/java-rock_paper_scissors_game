import java.util.*;

public class RockPaperScissors {

    // these are all the public variables so they can be accessed in multiple places.
    public static String optionSelected;
    public static String userOptionSelected;
    public static int userNumberChosen;
    public static int computerRandomNumber;
    public static int gameIsRunning = 1;
    public static int waitingForUserRetryChoice = 0;
    public static int waitingForCorrectUserEntry = 0;
    public static int computerScore = 0;
    public static int humanScore = 0;
    public static void main(String[] args) {
        while (gameIsRunning == 1) {
            int randomNumber;
            String optionSelected;

            // welcomes the user to the application.
            System.out.println("");
            System.out.println("Welcome to this Rock Paper Scissors Game.");
            System.out.println("");

            // this ensures the user is prompted at the end of each game to try again.
            RockPaperScissors.waitingForUserRetryChoice = 0;
            RockPaperScissors.waitingForCorrectUserEntry = 0;


            // this creates the random number between 1 and 3.
            computerRandomNumber = 1 + (int) (Math.random()* 3);
            
            //this checks to ensure the user's entry is valid.
            while (RockPaperScissors.waitingForCorrectUserEntry == 0) {
                // gets user input for rock, paper, or scissors.
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Please enter a value of 1 (Rock), 2 (Paper), or 3 (Scissors)");
                    RockPaperScissors.userNumberChosen = sc.nextInt();
                }
                catch(Exception e) {
                    System.out.println("Incorrect entry recorded, please try again.\n");
                }

                // this assigns the user option to a string.
                switch(RockPaperScissors.userNumberChosen) {
                    case 1:
                        RockPaperScissors.userOptionSelected = "Rock";
                        RockPaperScissors.waitingForCorrectUserEntry = 1;
                        break;
                    case 2:
                        RockPaperScissors.userOptionSelected = "Paper";
                        RockPaperScissors.waitingForCorrectUserEntry = 1;
                        break;
                    case 3:
                        RockPaperScissors.userOptionSelected = "Scissors";
                        RockPaperScissors.waitingForCorrectUserEntry = 1;
                        break;
                    default:
                        System.out.println("Incorrect option entered, please try again.\n");
                }
            }

            // this assigns the computer option to a string.
            switch(computerRandomNumber) {
                case 1:
                    RockPaperScissors.optionSelected = "Rock";
                    break;
                case 2:
                    RockPaperScissors.optionSelected = "Paper";
                    break;
                case 3:
                    RockPaperScissors.optionSelected = "Scissors";
                    break;
                default:
                    System.out.println("An exception occurred.");
            }

            /* This section of code prints what each person chose 
            and says who won and why, as well as it also adds the points
            to the winner for score tracking. */
            System.out.println("");
            if ((RockPaperScissors.computerRandomNumber == 1) & (RockPaperScissors.userNumberChosen == 1)) {
                System.out.println("You and the computer both chose Rock, so you tied!");
                System.out.println("");
            } else if ((RockPaperScissors.computerRandomNumber == 1) & (RockPaperScissors.userNumberChosen == 2)) {
                System.out.println("You chose Paper and the computer chose Rock, Paper beats Rock so you win!");
                System.out.println("");
                RockPaperScissors.humanScore = RockPaperScissors.humanScore + 1;
            } else if ((RockPaperScissors.computerRandomNumber == 1) & (RockPaperScissors.userNumberChosen == 3)) {
                System.out.println("You chose Scissors and the computer chose Rock, Rock beats Scissors so you lose.");
                System.out.println("");
                RockPaperScissors.computerScore = RockPaperScissors.computerScore + 1;
            } else if ((RockPaperScissors.computerRandomNumber == 2) & (RockPaperScissors.userNumberChosen == 1)) {
                System.out.println("You chose Rock and the computer chose Paper, Paper beats Rock so you lose.");
                System.out.println("");
                RockPaperScissors.computerScore = RockPaperScissors.computerScore + 1;
            } else if ((RockPaperScissors.computerRandomNumber == 2) & (RockPaperScissors.userNumberChosen == 2)) {
                System.out.println("You and the computer both chose Paper, so you tied!");
                System.out.println("");
            } else if ((RockPaperScissors.computerRandomNumber == 2) & (RockPaperScissors.userNumberChosen == 3)) {
                System.out.println("You chose Scissors and the computer chose Paper, Scissors beats Paper so you win!");
                System.out.println("");
                RockPaperScissors.humanScore = RockPaperScissors.humanScore + 1;
            } else if ((RockPaperScissors.computerRandomNumber == 3) & (RockPaperScissors.userNumberChosen == 1)) {
                System.out.println("You chose Rock and the computer chose Scissors, Rock beats Scissors so you win!");
                System.out.println("");
                RockPaperScissors.humanScore = RockPaperScissors.humanScore + 1;
            } else if ((RockPaperScissors.computerRandomNumber == 3) & (RockPaperScissors.userNumberChosen == 2)) {
                System.out.println("You chose Paper and the computer chose Scissors, Scissors beats Paper so you lose.");
                System.out.println("");
                RockPaperScissors.computerScore = RockPaperScissors.computerScore + 1;
            } else if ((RockPaperScissors.computerRandomNumber == 3) & (RockPaperScissors.userNumberChosen == 3)) {
                System.out.println("You and the computer both chose Scissors, so you tied!");
                System.out.println("");
            } else {
                System.out.println("Incorrect entry received.");
                System.out.println("");
            }

            // this section prints the score each round so the player can see how they are doing.
            System.out.println("Current Score, Player 1: " + humanScore + ", Computer: " + computerScore);
            System.out.println("");

            // checks the users input to see if their entry was valid or not for whether the game should continue.
            while (waitingForUserRetryChoice == 0) {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Would you like to play again? Enter yes or no to continue:");
                String userRetryChoice = sc2.nextLine();
                
                // this checks to see if the user wants to continue or not. 
                switch(userRetryChoice) {
                    case "yes":
                        RockPaperScissors.gameIsRunning = 1;
                        waitingForUserRetryChoice = 1;
                        break;
                    case "no":
                        RockPaperScissors.gameIsRunning = 2;
                        waitingForUserRetryChoice = 1;
                        break;
                    case "quit":
                        RockPaperScissors.gameIsRunning = 2;
                        waitingForUserRetryChoice = 1;
                        break;
                    case "end":
                        RockPaperScissors.gameIsRunning = 2;
                        waitingForUserRetryChoice = 1;
                        break;
                    case "stop":
                        RockPaperScissors.gameIsRunning = 2;
                        waitingForUserRetryChoice = 1;
                        break;
                    default:
                        System.out.println("");
                        System.out.println("Invalid entry, please enter yes or no.");
                        System.out.println("");
                        break;
                }
            }
        }
    }
}