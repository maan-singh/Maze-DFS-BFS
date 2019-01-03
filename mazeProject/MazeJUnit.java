package sjsu.MaanVargas.cs146.project2;

import static org.junit.Assert.*;
 
//NOTE: USES JUNIT 4!!!


/**
 * JUnit Testing for the maze.
 */
public class MazeJUnit {
 
    // 4x4 Maze
    @org.junit.Test
    public void maze4() {
        System.out.println("\n\n4x4 Maze");
        Maze maze = new Maze(4);
        System.out.print(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("BFS");
        System.out.print(maze.breadthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("DFS");
        System.out.print(maze.depthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        assertEquals(maze.breadthFirstSearch(), maze.depthFirstSearch());
    }
 
    // 5x5 Maze
    @org.junit.Test
    public void maze5() {
        System.out.println("\n\n5x5 Maze");
        Maze maze = new Maze(5);
        System.out.print(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("BFS");
        System.out.print(maze.breadthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("D"
        		+ "FS");
        System.out.print(maze.depthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        assertEquals(maze.breadthFirstSearch(), maze.depthFirstSearch());
    }
 
    // 6x6 Maze
    @org.junit.Test
    public void maze6() {
        System.out.println("\n\n6x6 Maze");
        Maze maze = new Maze(6);
        System.out.print(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("BFS");
        System.out.print(maze.breadthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("D"
        		+ "FS");
        System.out.print(maze.depthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        assertEquals(maze.breadthFirstSearch(), maze.depthFirstSearch());
    }
 
    // 7x7 Maze
    @org.junit.Test
    public void maze7() {
        System.out.println("\n\n7x7 Maze");
        Maze maze = new Maze(7);
        System.out.print(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("BFS");
        System.out.print(maze.breadthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("D"
        		+ "FS");
        System.out.print(maze.depthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        assertEquals(maze.breadthFirstSearch(), maze.depthFirstSearch());
    }
 
    // 8x8 Maze
    @org.junit.Test
    public void maze8() {
        System.out.println("\n\n8x8 Maze");
        Maze maze = new Maze(8);
        System.out.print(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("BFS");
        System.out.print(maze.breadthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("D"
        		+ "FS");
        System.out.print(maze.depthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        assertEquals(maze.breadthFirstSearch(), maze.depthFirstSearch());
    }
 
    // 10x10 Maze
    @org.junit.Test
    public void maze10() {
        System.out.println("\n\n10x10 Maze");
        Maze maze = new Maze(10);
        System.out.print(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("BFS");
        System.out.print(maze.breadthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        System.out.println("");
        System.out.println("");
        System.out.println("D"
        		+ "FS");
        System.out.print(maze.depthFirstSearch());
        System.out.println("");
        System.out.println("");
        System.out.println(maze.outputMaze());
        assertEquals(maze.breadthFirstSearch(), maze.depthFirstSearch());
    }
}