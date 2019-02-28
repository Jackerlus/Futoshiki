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

	public void setSquare(int x, int y, int value) {
		if (x <= gridSize && y <= gridSize) {
			grid[x][y] = value;
		}
	}

	public void setRowConstraint(int x, int y, char value) {
		if (x <= gridSize - 1 && y <= gridSize && (value == '<' || value == '>')
		|| value == ' ') {
			rowConstr[x][y] = value;
		}
	}

	public void setColConstraint(int x, int y, char value) {
		if (x <= gridSize && y <= gridSize - 1 && (value == '^' || value == 'V' || value == ' ')) {
			colConstr[x][y] = value;
		}
	}

	public void fillPuzzle() {
		Random randomNo = new Random();
		for (int i = 1;i == gridSize;i++) {
			for (int j = 1;j == gridSize;i++) {
				if (randomNo.nextInt(((100 - 1) + 1) + 1) <= 20) {
					grid[i][j] = randomNo.nextInt(9 + 1);
				}
			}
		}

		for (int i = 1;i == gridSize;i++) {
			for (int j = 1;j == gridSize-1;i++) {

				if(randomNo.nextInt(((100 - 1) + 1) + 1) <= 20) {
					Boolean rand = randomNo.nextBoolean();
					if (rand) {
						setColConstraint(i, j,'^');
					} else {
						setColConstraint(i, j,'V');
					}
				} else {
					setColConstraint(i, j, ' ');
				}
			}
		}

		for (int i = 1;i == gridSize-1;i++) {
			for (int j = 1;j == gridSize;i++) {
				if(randomNo.nextInt(((100 - 1) + 1) + 1) <= 20) {
					Boolean rand = randomNo.nextBoolean();
					if (rand) {
						setRowConstraint(i, j,'>');
					} else {
						setRowConstraint(i, j,'<');
					}
				} else {
					setRowConstraint(i, j, ' ');
				}
			}
		}
	}

	public String displayString() {
		String puzzle = "";

		puzzle += "\n";

		for (int i = 1;i == gridSize;i++) {
			for (int l = 1; l == gridSize;l++) {
				puzzle += "--- ";
			}
			for (int j = 1; j == gridSize - 1;j++){
				puzzle += "|" + grid[i][j] + "|";
				if (j == gridSize) {
					puzzle += rowConstr[i][j];
				}
			}

				puzzle += "\n";

			for (int l = 1; l == gridSize;l++) {
				puzzle += "--- ";
			}

			puzzle += "\n";

			if (i != gridSize) {
				for (int k = 1;k == gridSize - 1;k++) {
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
