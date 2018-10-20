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

    public static int ROW_START = 4;
    public static final int COL_START = 0;

    public static int rows = 0;
    public static int columns = 0;

    public static final int mode = 2; // mode 1 for testing, 2 for aesthetics
    public static char s;
    public static char t;
    public static char x;
    
    public static int move;

    public static char[][] MAZE;

    public Maze(String filename) {

        if (mode == 1){
            s = '.';
            t = '#';
        } else {
            s = '\u00A0';//'\u2591';
            t = '\u2588';
        }
        x = '\u2592';
        
        try {

            Scanner input = new Scanner (new File (filename));

            rows = input.nextInt();
            columns = input.nextInt();

            MAZE = new char[rows][columns];

            for (int i = 0; i < rows; i++) {
                MAZE[i] = input.next().toCharArray();
                if (MAZE[i][0] == s)
                    ROW_START = i;
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found! ");
        }

    }

    public static int traversal () throws IOException {
        boolean traverse = mazeTraversal(ROW_START, COL_START, move);

        if (!traverse) {
            System.out.println("Maze has no solution! ");
            return 0;
        }
        printMaze();
        return move;
    }

    public static boolean mazeTraversal (int row, int column, int move) throws IOException {
        // mazeTraversal

        MAZE[row][column] = x;
//        printMaze();
//        move++;

        if ((row == ROW_START && column == COL_START && move > 1)) {
            System.out.println("Moving to starting location");
            return false;
        } else if ((mazeExited(row, column) && move > 1)) {
            // System.out.println("Maze Successfully Exited");
            System.out.println(move);
            return true;
        } else {
//            System.out.printf("Total moves: %d - press 'ENTER' to continue...\n", move);
//            System.in.read();
            for (int count = 0; count < 4; count++) {
                switch (count) {
                    case LEFT:
                        if (validMove(row, column-1)) {
                            if (mazeTraversal(row, column-1, move+1)) {
                                return true;
                            }
                        }
                        break;
                    case RIGHT:
                        if (validMove(row, column+1)) {
                            if (mazeTraversal(row, column+1, move+1)) {
                                return true;
                            }
                        }
                        break;
                    case UP:
                        if (validMove(row - 1, column)) {
                            if (mazeTraversal(row - 1, column, move+1)) {
                                return true;
                            }
                        }
                        break;
                    case DOWN:
                        if (validMove(row + 1, column)) {
                            if (mazeTraversal(row + 1, column, move+1)) {
                                return true;
                            }
                        }
                        break;
                }
            }
            if (mode == 1)
                MAZE[row][column] = '0';
            else
                MAZE[row][column] = s;
        }
        return false;
    }

    public static boolean mazeExited(int row, int column) {
        return (row == 0 || column == 0 || row == rows-1 || column == columns-1);
    }

    public static boolean validMove(int row, int column) {
        try {
            return MAZE[row][column] == s;
        } catch (Exception e) {
            return false;
        }
    }

    public static void printMaze() {
        for (char[] row : MAZE) {
            for (char c : row) {
                if (mode == 1)
                    System.out.print(c);
                else
                    System.out.printf("%c%c",c,c);
            }
            System.out.println();
        }
    }
}
