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

        int userChoice = 0;

        while (true) {
            // options for user to select from
            System.out.println("Select from an option below:");
            System.out.println("1: To load a puzzle from an existing file.");
            System.out.println("2: To select from an available puzzle.");
            System.out.println("3. To exit.");

            try {
                userChoice = myScanner.nextInt();

                if (userChoice < 1 || userChoice > 3)
                {
                    throw new IllegalArgumentException("Invalid choice. Please enter a number between 1 and 3.");
                }
                else {
                    /*
                     break out of the loop
                     if user input is valid
                    */
                    break;
                }
            }
            catch (Exception e) {
                // handle invalid input
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                myScanner.nextLine();
            }
        }
        System.out.println("You chose option: " + userChoice);

    }
}
