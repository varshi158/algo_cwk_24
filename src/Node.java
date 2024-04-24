public class Node {

    // row and column indices of the node
    int row;
    int col;

    // parent node of the current node
    Node parent;

    // construct a new node with its row index,
    // column index, and parent node.
    public Node(int row, int col, Node parent) {
        this.row = row;
        this.col = col;
        this.parent = parent;
    }

}
