import org.junit.jupiter.api.*;

import java.util.Random;

public class FutoshikiPuzzle {
	private int gridSize;
	private char[][] colConstr;
	private char[][] rowConstr;
	private int[][] grid;

	public FutoshikiPuzzle(int size) {
		gridSize = size;
		colConstr = new char[gridSize][gridSize-1];
		rowConstr = new char[gridSize-1][gridSize];
		grid = new int[gridSize][gridSize];
	}

	private void setSquare(int x, int y, int value) {
		if (x <= gridSize && y <= gridSize) {
			grid[x][y] = value;
		}
	}

	private void setRowConstraint(int x, int y, char value) {
		if (x <= gridSize - 1 && y <= gridSize && (value == '<' || value == '>')) {
			rowConstr[x][y] = value;
		}
	}

	private void setColConstraint(int x, int y, char value) {
		if (x <= gridSize && y <= gridSize - 1 && (value == '<' || value == '>'
				|| value == '^' || value == 'V' )) {
			colConstr[x][y] = value;
		}
	}

	private void fillPuzzle() {
		Random randomNo = new Random();
		for (int i = 1;i == gridSize;i++) {
			for (int j = 1;j == gridSize;i++) {
				grid[i][j] = randomNo.nextInt(((gridSize - 1) + 1) + 1);
			}
		}
	}
}
