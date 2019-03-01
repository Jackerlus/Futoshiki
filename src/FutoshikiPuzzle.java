import java.util.Random;

class FutoshikiPuzzle {
	private int gridSize;
	private char[][] colConstr;
	private char[][] rowConstr;
	private int[][] grid;

	public FutoshikiPuzzle(int size) {
		gridSize = size;
		colConstr = new char[gridSize][gridSize - 1];
		rowConstr = new char[gridSize - 1][gridSize];
		grid = new int[gridSize][gridSize];
	}

	public int getGridSize() {
		return gridSize;
	}

	public char[][] getColConstr() {
		return colConstr;
	}

	public char[][] getRowConstr() {
		return rowConstr;
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setSquare(int x, int y, int value) {
		if (x <= gridSize && y <= gridSize) {
			grid[x][y] = value;
		} else {
			System.out.println("Error - invalid input.");
		}
	}

	public void setRowConstraint(int x, int y, char value) {
		if (x <= gridSize - 1 && y <= gridSize && (value == '<' || value == '>')
				|| value == ' ') {
			rowConstr[x][y] = value;
		} else {
			System.out.println("Error - invalid input.");
		}
	}

	public void setColConstraint(int x, int y, char value) {
		if (x < gridSize && y < gridSize - 1 && (value == '^' || value == 'V' || value == ' ')) {
			colConstr[x][y] = value;
		} else {
			System.out.println("Error - invalid input.");
		}
	}

	public void fillPuzzle() {
		Random randomNo = new Random();
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (randomNo.nextInt(((100 - 1) + 1) + 1) <= 20) {
					setSquare(i, j, randomNo.nextInt(9 + 1));
				}
			}
		}

		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize - 1; j++) {

				if (randomNo.nextInt(((100 - 1) + 1) + 1) <= 20) {
					Boolean rand = randomNo.nextBoolean();
					if (rand) {
						setColConstraint(i, j, '^');
					} else {
						setColConstraint(i, j, 'V');
					}
				} else {
					setColConstraint(i, j, ' ');
				}
			}
		}

		for (int i = 0; i < gridSize - 1; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (randomNo.nextInt(((100 - 1) + 1) + 1) <= 20) {
					Boolean rand = randomNo.nextBoolean();
					if (rand) {
						setRowConstraint(i, j, '>');
					} else {
						setRowConstraint(i, j, '<');
					}
				} else {
					setRowConstraint(i, j, ' ');
				}
			}
		}
	}

	public String displayString() {

		String puzzle = "";

		for (int i = 0; i < gridSize; i++) {
			for (int l = 0; l < gridSize; l++) {
				puzzle += "--- ";
			}

			puzzle += "\n";

			for (int j = 0; j < gridSize; j++) {
				puzzle += "|" + grid[i][j] + "|";
				if (j != gridSize - 1) {
					if (i >= gridSize - 1) {
						puzzle += rowConstr[i - 1][j];
					} else {
						puzzle += rowConstr[i][j];
					}
				}
			}

			puzzle += "\n";

			for (int m = 0; m < gridSize; m++) {
				puzzle += "--- ";
			}

			puzzle += "\n";

			if (i < gridSize - 1) {
				for (int k = 0; k < gridSize - 1; k++) {
					puzzle += " " + colConstr[i][k] + "  ";
				}
			}

			puzzle += "\n";
		}
		return puzzle;
	}

	public static void main(String[] args) {
		FutoshikiPuzzle futoshiki = new FutoshikiPuzzle(Integer.parseInt(args[0]));
		futoshiki.fillPuzzle();
		System.out.println(futoshiki.displayString());
	}
}
