package sjsu.MaanVargas.cs146.project2;

import java.util.*;
 
/**
 * This class will make a maze the will use BFS and DFS to solve itself randomly.
 */
public class Maze {
    private Cell cellArray[]; // Array to store the cells of the maze.
    private Cell adjMatrix[][]; // adjacency matrix representing edges.
    private int sizeOfadjMatrix; // adjacency matrix size.
    private Random aRandomNum; // Random number generator used to choose which maze wall to destroy randomly.
 
    /**
     * Constructor for the maze.
     * @param mazeDimension the maze dimension.
     */
    public Maze(int mazeDimension) {
        cellArray = new Cell[mazeDimension*mazeDimension];
        adjMatrix = new Cell[mazeDimension][mazeDimension];
        sizeOfadjMatrix = adjMatrix.length-1;
        aRandomNum = new Random(0); // Randomizer.
        // Method to store 'mazeDimension' cells in the array and the 2D array of cell objects.
        storeCells(mazeDimension);
        // Method called that builds an perfect random maze
        buildMaze();
    }
   
    /**
     * Method to store 'mazeDimension' cell objects in the data structures cellArray[] & adjMatrix[][].
     * @param mazeDimension the dimension of the maze.
     */
    public void storeCells(int mazeDimension) {
        int counter = 0;
        // Loop to store 'mazeDimension' cells in the array and the 2D array described above.
        for (int m= 0; m< mazeDimension; m++) {
            for (int n= 0; n< mazeDimension; n++) {
                Cell cell = new Cell(m, n);
                adjMatrix[m][n] = cell;
                cellArray[counter] = cell;
                counter++;
            }
        }
    }
 
    /**
     * This method builds a perfect maze.
     */
    public void buildMaze() {
        Stack<Cell> cellStack = new Stack<Cell>(); // create a CellStack (LIFO) to hold a list of cell locations.
        int totalCells = cellArray.length; // set TotalCells= number of cells in grid.
        Cell currentCell = adjMatrix[0][0]; // choose the starting cell and call it currentCell.
        int visitedCells = 1; // set VisitedCells = 1 since it visited the starting cell.
 
        while (visitedCells< totalCells) {
            ArrayList<Cell> adjCellList = adjacentCells(currentCell); // find all neighbors of CurrentCell with all walls intact.
            Cell cellPointer = currentCell; // Points to the current cell.
 
            if (adjCellList.size()> 0 ) {
                cellStack.push(currentCell); // push CurrentCell location on the CellStack.
                int randomIndex = (int)(myRandom()*adjCellList.size()); // if one or more found choose one at random.
                currentCell = adjCellList.get(randomIndex); // make the new cell CurrentCell.
                knockDownWall(currentCell, cellPointer); // knock down the wall between it and CurrentCell.
                visitedCells++; // add 1 to VisitedCells.
               
                cellPointer.adjList.add(currentCell);
                currentCell.adjList.add(cellPointer);
            }
            else {
                currentCell = cellStack.pop(); // pop the most recent cell entry off the CellStack.
            }
        }
        adjMatrix[0][0].aboveWall = false; // marks the entrance of the maze.
        adjMatrix[sizeOfadjMatrix][sizeOfadjMatrix].bottomWall = false; // marks the exit of the maze.
    }
   
    /**
     * Method to find all the adjacent cells of a given cell.
     * @param aCell
     * @return an ArrayList of all neighboring cells.
     */
    public ArrayList<Cell> adjacentCells(Cell aCell) {
        ArrayList<Cell> adjCellList = new ArrayList<Cell>();
        // Loop to see if there is a cell to the left of 'aCell'.
        if (aCell.col> 0 && seeWallsIntact(adjMatrix[aCell.row][aCell.col-1])) {
            adjCellList.add((adjMatrix[aCell.row][aCell.col-1]));
        } // Loop to see if there is a cell to the right of 'aCell'.
        if (aCell.col < sizeOfadjMatrix && seeWallsIntact(adjMatrix[aCell.row][aCell.col + 1])) {
            adjCellList.add(adjMatrix[aCell.row][aCell.col + 1]);
        } // Loop to see if there is a cell to the top of 'aCell'.
        if (aCell.row > 0 && seeWallsIntact(adjMatrix[aCell.row - 1][aCell.col])) {
            adjCellList.add((adjMatrix[aCell.row - 1][aCell.col]));
        } // Loop to see if there is a cell to the bottom of 'aCell'.
        if (aCell.row < sizeOfadjMatrix && seeWallsIntact(adjMatrix[aCell.row + 1][aCell.col])) {
            adjCellList.add((adjMatrix[aCell.row + 1][aCell.col]));
        }
        return adjCellList;
    }
 
    /**
     * Method to see if the adjacent cell has been visited or not by checking if a wall still exists between them.
     * @param aCell
     * @return true or false depending on the existence of surrounding walls.
     */
    public boolean seeWallsIntact(Cell aCell) {
        return aCell.aboveWall && aCell.bottomWall && aCell.leftWall && aCell.rightWall;
    }
   
    /**
     * Method to break down walls between two given cells.
     * @param cell1 the first cell
     * @param cell2 the second cell
     */
    public void knockDownWall(Cell cell1, Cell cell2) {
        // Loop to see if the cell equals to the cell1 equals to cell2 that is located left to it.
        if (cell1.col> 0 && adjMatrix[cell1.row][cell1.col-1].equals(cell2)) {
            cell1.aboveWall = false;
            cell2.bottomWall = false;
        } // Loop to see if the cell equals to the cell1 equals to cell2 that is located right to it.
        else if (cell1.col< sizeOfadjMatrix && adjMatrix[cell1.row][cell1.col+1].equals(cell2)) {
            cell1.bottomWall = false;
            cell2.aboveWall = false;
        } // Loop to see if the cell equals to the cell1 equals to cell2 that is located above to it.
        else if (cell1.row> 0 && adjMatrix[cell1.row-1][cell1.col].equals(cell2)) {
            cell1.leftWall = false;
            cell2.rightWall = false;
        } // Loop to see if the cell equals to the cell1 equals to cell2 that is located bottom to it.
        else if (cell1.row< sizeOfadjMatrix && adjMatrix[cell1.row+1][cell1.col].equals(cell2)) {
            cell1.rightWall = false;
            cell2.leftWall = false;
        }
    }
 
    /**
     * Method to print the maze in the console using ASCII characters.
     * @return String representation of maze
     */
    public String outputMaze() {
        String stringMaze= "";
        for (int i= 0; i< adjMatrix.length; i++) {
            stringMaze+=(i== 0)? "+ ": "+-";
        }
        stringMaze+= "+\n";
        for (int i= 0; i< adjMatrix.length; i++) {
            stringMaze+= "|";
            for (int j = 0; j< adjMatrix.length- 1; j++){
                stringMaze+= (adjMatrix[j][i].discTime> -1)? adjMatrix[j][i].discTime% 10: " ";
                stringMaze+= (adjMatrix[j][i].rightWall)?  "|": " ";
            }
            stringMaze+= (adjMatrix[adjMatrix.length-1][i].discTime> -1)? adjMatrix[adjMatrix.length-1][i].discTime% 10 +"|\n+": " |\n+";
            if (i< adjMatrix.length- 1) {
                for (int j= 0; j< adjMatrix.length; j++) {
                    stringMaze+= (adjMatrix[j][i].bottomWall)? "-+": " +";
                }
                stringMaze+= "\n";
            }
        }
        for (int i = 0; i< adjMatrix.length; i++) {
            stringMaze+= (!adjMatrix[i][adjMatrix.length-1].bottomWall)? " ": "-+";
        }
        stringMaze+= "+";
        return stringMaze;
    }
 
    /**
     * Method to solve the maze needed for a specific search algorithm (BFS or DFS).
     * @return solved maze.
     */
    public String solve() {
        String stringMaze= "";
        // Loop running to output the top.
        for (int i= 0; i< adjMatrix.length; i++) {
            stringMaze+= (i == 0)? "+#": "+-";
        }
        stringMaze+= "+\n";
        // Loop running to output sides and bottom.
        for (int i= 0; i < adjMatrix.length; i++) {
            stringMaze+= "|";
            for (int j= 0; j< adjMatrix.length- 1; j++){
                if (adjMatrix[j][i].rightWall) {
                    stringMaze+= (adjMatrix[j][i].stringValue.equals("#"))? "#|": " |";
                } else {
                    if (adjMatrix[j][i].stringValue.equals("#")) {
                        stringMaze+= "#";
                        stringMaze+= (adjMatrix[j+1][i].stringValue.equals("#"))? "#": " ";
                    } else {
                        stringMaze+= "  ";
                    }
                }
            }
            stringMaze+= adjMatrix[adjMatrix.length-1][i].stringValue.equals("#")? "#|\n+": " |\n+";
            if (i< adjMatrix.length- 1) {
                for (int j= 0; j< adjMatrix.length; j++) {
                    if (adjMatrix[j][i].bottomWall) {
                        stringMaze+= "-";
                    }
                    else {
                        stringMaze+= (adjMatrix[j][i].stringValue.equals("#"))? "#": " ";
                    }
                    stringMaze+= "+";
                }
                stringMaze+= "\n";
            }
        }
        for (int i= 0; i< adjMatrix.length; i++) {
            stringMaze+= (!adjMatrix[i][adjMatrix.length-1].bottomWall)? "#": "-+";
        }
        stringMaze+= "+";
        return stringMaze;
    }
   
    /**
     * Method to print the Breadth-First Search maze output.
     * @return output of maze with Breadth-First Search (BFS).
     */
    public String breadthFirstSearch() {
        // Renews the maze and gets sets initial conditions required to run search algorithm.
        for (int i= 0; i< cellArray.length; i++) {
            cellArray[i].discTime= -100;
            cellArray[i].prev= null;
            cellArray[i].cellColor= cellStatus.white;
        }
        Queue<Cell> cellQueue = new LinkedList<Cell>(); // Queue initiated to run BSF.
        Cell currentCell = cellArray[0];
        cellQueue.add(currentCell);
        int discTime= 0;
        // While queue not empty.
        while(!cellQueue.isEmpty() && !currentCell.equals(cellArray[cellArray.length-1])) {
            currentCell= cellQueue.remove(); // Remove cell from queue.
            currentCell.cellColor= cellStatus.black; // Set color to Black as it is discovered.
            currentCell.discTime= discTime; // Set discovery time while visiting the cell.
            discTime++;
            // Loop that runs through unvisited (white) cells and set the color to gray and add previous property to it pointing to the 'previous' cell.
            for (Cell cell: currentCell.adjList) {
                if (cell.cellColor== cellStatus.white) {
                    cell.prev= currentCell;
                    cell.cellColor= cellStatus.gray;
                    cellQueue.add(cell);
                }
            }
        }
        // Loop to add # describing path from entrance to exit of the maze.
        while (currentCell!= cellArray[0]) {
            currentCell.stringValue= "#";
            currentCell= currentCell.prev;
        }
        currentCell.stringValue ="#";

        return solve();
    }
 
    /**
     * Method to print the Depth-First Search maze output.
     * @return output of maze with Depth-First Search (DFS).
     */
    public String depthFirstSearch() {
        // Renews the maze and gets sets initial conditions required to run search algorithm.
        for (int i= 0; i< cellArray.length; i++) {
            cellArray[i].discTime= -100;
            cellArray[i].prev= null;
            cellArray[i].cellColor= cellStatus.white;
        }
        Stack<Cell> cellStack = new Stack<Cell>();
        Cell currentCell = cellArray[0];
        cellStack.push(currentCell);
        int discTime= 0;
        // While stack is not empty.
        while (!cellStack.isEmpty() && !currentCell.equals(cellArray[cellArray.length-1])) {
            currentCell= cellStack.pop(); // Remove cell from stack.
            currentCell.cellColor= cellStatus.black; // Set color to Black as it is discovered.
            currentCell.discTime= discTime; // Set discovery time while visiting the cell.
            discTime++;
            // Loop that runs through unvisited (white) cells and set the color to gray and add previous property to it pointing to the 'previous' cell.
            for (Cell cell: currentCell.adjList) {
                if (cell.cellColor== cellStatus.white) {
                    cell.prev= currentCell;
                    cell.cellColor= cellStatus.gray;
                    cellStack.add(cell);
                }
            }
        }
        // Loop to add # describing path from entrance to exit of the maze.
        while(currentCell!= cellArray[0]) {
            currentCell.stringValue= "#";
            currentCell= currentCell.prev;
        }
        currentCell.stringValue= "#";

        return solve();
    }
   
    /*
     * Method to get a random number between 0 and 1. Used to knock down random wall during maze generation
     * @return a random number between 0 and 1.
     */
    public double myRandom() {
        return aRandomNum.nextDouble();
    }
   
    /*
     * Tester method to see the mazes being made
     */
//    public static void main(String args[]) {
//        Maze maze = new Maze(5);
//        System.out.println(maze.outputMaze());
//        System.out.println("");
//        System.out.print(maze.breadthFirstSearch());
//        System.out.print(maze.depthFirstSearch());
//
//      }
 
}