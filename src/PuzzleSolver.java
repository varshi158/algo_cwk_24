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


    }
}