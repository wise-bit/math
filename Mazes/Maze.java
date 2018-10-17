package unit2_recursion.Mazes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Maze {


    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    public static final int ROW_START = 4;
    public static final int COL_START = 0;

    public static int rows = 0;
    public static int columns = 0;

    public static int move;

    public static char[][] MAZE;

    public Maze(String filename) {

        try {

            Scanner input = new Scanner (new File (filename));

            rows = input.nextInt();
            columns = input.nextInt();

            MAZE = new char[rows][columns];

            for (int i = 0; i < rows; i++)
                MAZE[i] = input.next().toCharArray();

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found! ");
        }

    }

    public static void traversal () throws IOException {
        boolean traverse = mazeTraversal(ROW_START, COL_START);

        if (!traverse)
            System.out.println("Maze has no solution! ");

    }

    public static boolean mazeTraversal (int row, int column) throws IOException {
        // mazeTraversal

        MAZE[row][column] = 'x';
        printMaze();
        move++;

        if ((row == ROW_START && column == COL_START && move > 1)) {
            System.out.println("Moving to starting location");
            return false;
        } else if ((mazeExited(row, column) && move > 1)) {
            System.out.println("Maze Successfully Exited");
            System.exit(0);
            return false;
        } else {
            System.out.printf("Total moves: %d - press 'ENTER' to continue...\n", move);
            System.in.read();
            for (int count = 0; count < 4; count++) {
                switch (count) {
                    case LEFT:
                        if (validMove(row, column-1)) {
                            if (mazeTraversal(row, column-1)) {
                                return true;
                            }
                        }
                        break;
                    case RIGHT:
                        if (validMove(row, column+1)) {
                            if (mazeTraversal(row, column+1)) {
                                return true;
                            }
                        }
                        break;
                    case UP:
                        if (validMove(row - 1, column)) {
                            if (mazeTraversal(row - 1, column)) {
                                return true;
                            }
                        }
                        break;
                    case DOWN:
                        if (validMove(row + 1, column)) {
                            if (mazeTraversal(row + 1, column)) {
                                return true;
                            }
                        }
                        break;
                }
            }
            MAZE[row][column] = '0';
        }
        return false;
    }

    public static boolean mazeExited(int row, int column) {
        return (row == 0 || column == 0 || row == rows-1 || column == columns-1);
    }

    public static boolean validMove(int row, int column) {
        try {
            return MAZE[row][column] == '.';
        } catch (Exception e) {
            return false;
        }
    }

    public static void printMaze() {
        for (char[] row : MAZE) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
