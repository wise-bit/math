package unit2_recursion.Mazes;

import java.io.IOException;

public class mazeMaker {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;

    public static final char s = '.';//'\u2591';
    public static final char t = '#';//'\u2588';

    public static int ROW_START = 0;
    public static final int COL_START = 1;

    public final static int rows = 13;
    public final static int columns = 13;

    public static int move = 0;

    public static char[][] maze;

    public mazeMaker() {
        maze = new char[rows][columns];
        initialization();
    }

    public static void starter () {

        while (ROW_START == 0) {
            int x = (int) (Math.random()*rows)-1;
            if (x%2 == 1 && x > 1)
                ROW_START = x;
        }

        generation(ROW_START, COL_START, (int) Math.round(Math.random()), 0);

        boolean changedStart = false;
        boolean changedEnd = false;

        while (changedStart == false) {
            int i = (int) (Math.random()*rows);
            if (maze[i][1] == s) {
                maze[i][0] = s;
                changedStart = true;
            }
        }
        while (changedEnd == false) {
            int i = (int) (Math.random()*rows);
            if (maze[i][columns-2] == s) {
                maze[i][columns-1] = s;
                changedEnd = true;
            }
        }

        printMaze();
    }

    public static boolean generation (int row, int column, int which, int howmuch) {

        move++;

        maze[row][column] = s;
        if (which == 0 && move > 1)
            maze[row][column-howmuch] = s;
        else if (which == 1 && move > 1)
            maze[row-howmuch][column] = s;

        if (row == ROW_START && column == COL_START && move > 1) {

            System.out.println("Maze finished");
            return false;

        } else{

//            System.out.printf("Total moves: %d - press 'ENTER' to continue...\n", move);
//            System.in.read();

            while (!noMovesLeft(row, column)){
                switch ((int) (Math.random()*4)) {
                    case LEFT:
                        if (validMove(row, column-2)) {
                            if (generation(row, column-2, 0, -1)) {
                                return true;
                            }
                        }
                        break;
                    case RIGHT:
                        if (validMove(row, column+2)) {
                            if (generation(row, column+2, 0, 1)) {
                                return true;
                            }
                        }
                        break;
                    case UP:
                        if (validMove(row - 2, column)) {
                            if (generation(row - 2, column, 1, -1)) {
                                return true;
                            }
                        }
                        break;
                    case DOWN:
                        if (validMove(row + 2, column)) {
                            if (generation(row + 2, column, 1, 1)) {
                                return true;
                            }
                        }
                        break;
                }
            }
        }
        return false;

    }

    public static void initialization () {
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                maze[i][j] = t;
            }
        }
    }

    public static boolean noMovesLeft (int row, int column) {
        return !validMove(row+2, column) && !validMove(row-2, column) && !validMove(row, column+2) && !validMove(row, column-2);
    }

    public static boolean validMove (int row, int column) {
        return row >= 1 && column >= 1 && row < rows && column < columns && maze[row][column] == t;
    }

    public static void printMaze() {
        for (char[] row : maze) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }

}

/*
BufferedWriter out = new BufferedWriter(new FileWriter(file));
out.write("Write the string to text file");
out.newLine();
 */

