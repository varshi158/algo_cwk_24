import java.util.InputMismatchException;
import java.util.Scanner;

public class PuzzleMain {
    public static void main(String[] args) {
        System.out.println(
                """
                =============================================
                |     WELCOME TO THE SLIDING PUZZLE GAME    |
                =============================================
                """);

        // Scanner class to read user input
        Scanner myScanner = new Scanner(System.in);

        int userChoice;

        /* keeps running until valid input is entered */
        while (true) {
            // options for user to select from
            System.out.println("Select from an option below:");
            System.out.println("1: To display a demo of the game.");
            System.out.println("2: To select from an available puzzle.");
            System.out.println("3: To exit.");

            try {
                userChoice = myScanner.nextInt();

                if (userChoice < 1 || userChoice > 3)
                {
                    System.out.println("\nInvalid input. " +
                            "Please enter a number between 1 and 3.");
                }
                else {
                    /* break out of the loop
                    only if user input is valid */
                    break;
                }
            }
            catch (InputMismatchException e) {
                // handle invalid input
                System.out.println("\nInvalid input. " +
                        "Please enter a number between 1 and 3.");
                myScanner.nextLine();
            }
        } // end of while loop - user input

        // enhanced switch statement to handle user choice
        switch (userChoice) {
            // load puzzle from file
            case 1 -> displayDemo();

            // select puzzle to load
            case 2 -> System.out.println(" ");

            // exit from the program
            case 3 -> System.out.println("Exiting from the game..." +
                    "\nSee you soon!");
        }// end of switch statement
    } // end of main method


    // Method to display a demo of the game
    private static void displayDemo() {
        // Create an instance of PuzzleMap to load the puzzle from file
        PuzzleMap demoPuzzle = new PuzzleMap("examples", "maze10_1.txt");

        // Get the loaded puzzle from PuzzleMap
        char[][] demoPuzzleArray = demoPuzzle.getPuzzle();

        // Display details of the loaded puzzle
        System.out.println("\nLoading puzzle -> 'examples/maze10_1.txt'");
        for (char[] row : demoPuzzleArray) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    } // end of displayDemo method

}
