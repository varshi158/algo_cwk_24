import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PuzzleMap {
    private char [][] puzzle;

    public PuzzleMap (String folderName, String fileName) {
        loadPuzzle(folderName, fileName);
    }

    //
    private void loadPuzzle(String folderName, String fileName) {
        try {
            // create file object for the puzzle file
            File puzzleFile = new File(folderName + File.separator + fileName);

            // Scanner class to read from the file
            Scanner myScanner = new Scanner(puzzleFile);

            /* initialise height and width
            of the puzzle with default value */
            int numRows = 0;
            int numCols = 0;

            // redeclare the height and width
            while (myScanner.hasNextLine()) {
                numRows++;
                String line = myScanner.nextLine();
                int rowLength = line.length();
                if(rowLength > numCols) {
                    numCols = rowLength;
                }
            }

            /* reset scanner to read from the
            beginning of the puzzle file again */
            myScanner.close();
            myScanner = new Scanner(puzzleFile);

            // initialise puzzle array with the dimensions
            puzzle = new char[numRows][numCols];

            // Read puzzle lines from the file and store them in the 2D array
            int row = 0;
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                for (int col = 0; col < numCols; col++) {
                    puzzle[row][col] = line.charAt(col);
                }
                row++;
            }
        }
        catch (FileNotFoundException e) {
            // handle file not found exception
            //System.out.println("File not found: " + e.getMessage());
        }
    }

    // Method to retrieve the loaded puzzle
    public char[][] getPuzzle() {
        return puzzle;
    }
}
