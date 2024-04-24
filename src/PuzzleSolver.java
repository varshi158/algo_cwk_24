import java.util.LinkedList;
import java.util.Queue;

public class PuzzleSolver {

    // method to solve the puzzle using bfs
    public static void bfsPathFinder(char [][] puzzle, int startPointRow, int startPointCol, int finishPointRow, int finishPointCol) {

        // initialise array to keep track of visited nodes
        boolean [][] visitedNodes = new boolean[puzzle.length][puzzle[0].length];

        // initialise queue for bfs
        Queue<Node> queue = new LinkedList<>();

        // initialise start node
        Node startNode = new Node(startPointRow, startPointCol, null);

        // add the start node to the queue
        queue.offer(startNode);

        // perform bfs while the queue is not empty
        while (!queue.isEmpty()) {

            // retrieve current node's index position
            Node currentNode = queue.poll();
            int row = currentNode.row;
            int col = currentNode.col;

            // check if current node is equal to finishing cell
            if (row == finishPointRow && col == finishPointCol) {
                //displayStoFPath(currentNode);
                return;
            }

            // set current node to be "true"
            // because it has been visited
            visitedNodes[row][col] = true;

            // visit adjacent cells
            for (int[] direction : getDirections()) {
                // calculate new row and column indices
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check if the new cell is within bounds, not a rock, and not visited
                if (isValidMove(puzzle, visitedNodes, newRow, newCol)) {
                    // Add the new cell to the queue
                    queue.offer(new Node(newRow, newCol, currentNode));
                }
            }
        }
    }

    // method to get the directions: up, down, left, right
    private static int [][] getDirections() {
        int [][] directions = {
                {-1, 0}, // Up
                {1, 0},  // Down
                {0, -1}, // Left
                {0, 1}   // Right
        };
        return directions;
    }

    // method to check if a move is valid
    private static boolean isValidMove(char[][] puzzle, boolean[][] visited, int row, int col) {
        boolean withinRowBounds = row >= 0 && row < puzzle.length;
        boolean withinColBounds = col >= 0 && col < puzzle[0].length;
        boolean notObstacle = puzzle[row][col] != '0';
        boolean notVisited = !visited[row][col];

        return withinRowBounds && withinColBounds && notObstacle && notVisited;
    }

}