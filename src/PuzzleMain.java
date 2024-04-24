import java.util.InputMismatchException;
import java.util.Scanner;

public class PuzzleMain {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(
                """
                =============================================
                ||     WELCOME TO THE SLIDING PUZZLE GAME  ||
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
            case 2 -> selectPuzzle();

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

        // method to solve puzzle
        PuzzleSolver.bfsPathFinder(demoPuzzleArray,
                demoPuzzle.getStartPointRow(), demoPuzzle.getStartPointCol(),
                demoPuzzle.getFinishPointRow(), demoPuzzle.getFinishPointCol());

    } // end of displayDemo method

    private static void selectPuzzle() {
        Scanner myScanner = new Scanner(System.in);
        int selectedFolderNum;

        do {
            System.out.println();
            System.out.print("""
                To make a selection, enter 1 or 2.
                1: To select "examples" folder
                2: To select "benchmark_series" folder
                """);

            /* keeps looping as long as user
            enters an integer
             */
            while (!myScanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                myScanner.nextLine();
            }

            // stores user input
            selectedFolderNum = myScanner.nextInt();
            myScanner.nextLine();

            // checks if valid integer number was entered
            if (selectedFolderNum != 1 && selectedFolderNum != 2) {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        } while (selectedFolderNum != 1 && selectedFolderNum != 2);

        // assign name for selected folder
        String selectedFolder = (selectedFolderNum == 1) ? "examples" : "benchmark_series";


        System.out.println();
        System.out.println("Enter the name of the puzzle file " +
                "that you would like to open. \nFile extension is not required.");
        String fileName = myScanner.next() + ".txt";

        try {
            PuzzleMap myPuzzle = new PuzzleMap(selectedFolder, fileName);

            // Get the loaded puzzle from PuzzleMap
            char[][] puzzleArray = myPuzzle.getPuzzle();


            // Display details of the loaded puzzle
            System.out.println("\nLoading puzzle -> '" + selectedFolder + "/" + fileName);
            for (char[] row : puzzleArray) {
                for (char element : row) {
                    System.out.print(element);
                }
                System.out.println();
            }

            // method to solve puzzle
            PuzzleSolver.bfsPathFinder(puzzleArray,
                    myPuzzle.getStartPointRow(), myPuzzle.getStartPointCol(),
                    myPuzzle.getFinishPointRow(), myPuzzle.getFinishPointCol());
        }
        // handle possible exceptions
        catch (Exception e) {
            System.out.println("An error occurred!!\n" + e.getMessage());
        }

    } // end of selectPuzzle method

}
