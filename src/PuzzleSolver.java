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

            // set current node to "true"
            // because it has been visited
            visitedNodes[row][col] = true;
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
}