package unit2_recursion.Mazes;

import java.io.IOException;

public class mazeBase {
	
	public static void main(String args[]) throws IOException {
//		Maze Maze = new Maze("mazeLayout.txt");
//		Maze.traversal();
		mazeMaker maker = new mazeMaker();
		maker.starter();
	}

}
