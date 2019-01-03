package sjsu.MaanVargas.cs146.project2;

import java.util.LinkedList;

public class Cell {
	
	int row; // Row number of cell.
    int col; // Column number of cell. 
    String stringValue; // String for filling up the cell while running Breadth-First Search (Either # or left blank).
    Cell prev; // The previous cell.
    cellStatus cellColor; // The color of the cell for BFS and DFS (White when unvisited, Gray if discovered, Black if finished).
    int discTime; // The discovery time of the cell.
    LinkedList<Cell> adjList; // An adjacency linked list to store neighboring cells.
    boolean aboveWall = true; // The wall above the cell.
    boolean bottomWall = true; // The wall below the cell.
    boolean leftWall = true; // The wall left to the cell.
    boolean rightWall = true; // The wall right to the cell.

    /**
     * Constructor for the cell.
     * @param row the row of the cell.
     * @param col the column of the cell.
     */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.prev = null;
        this.stringValue = "";
        this.discTime = -100;
        adjList = new LinkedList<Cell>();
    }

}
