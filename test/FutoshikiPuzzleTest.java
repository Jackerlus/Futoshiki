import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FutoshikiPuzzleTest{
    public FutoshikiPuzzleTest(int testSize) {
        int size = testSize;
        futoshiki = new FutoshikiPuzzle(size);
    }

    private FutoshikiPuzzle futoshiki;

    @Test
    //Test that grid numbers are being set
    public void testSetSquare() {
        futoshiki.setSquare(2, 3, 9);
        assertEquals(9, futoshiki.getGrid()[2][3]);
    }

    @Test
    //Test that row constraints are being set
    public void testSetRowConstraint() {
        futoshiki.setRowConstraint(2, 2, '<');
        assertEquals('<', futoshiki.getRowConstr()[2][2]);
    }

    @Test
    //Test that column constraints are being set
    public void testSetColConstraint() {
        futoshiki.setColConstraint(2, 2, '^');
        assertEquals('^', futoshiki.getColConstr()[2][2]);
    }

    @Test
    public void testFillPuzzle() {
        futoshiki.fillPuzzle();

        //The following code tests that the individual grid numbers are within valid limits
        boolean puzzleFlag = true;
        for (int i = 0; i < futoshiki.getGridSize();i++) {
            for (int j = 0; j < futoshiki.getGridSize();j++) {
                if (futoshiki.getGrid()[i][j] > 9 || futoshiki.getGrid()[i][j] < 0) {
                    puzzleFlag = false;
                    break;
                }
            }
            if (!puzzleFlag) {
                break;
            }
        }
        assertTrue(puzzleFlag);

        //The following code tests that the column constraints align with valid values
        boolean colFlag = false;
        for (int i = 0; i < futoshiki.getGridSize() - 2;i++) {
            for (int j = 0; j < futoshiki.getGridSize() - 1;j++) {
                if (futoshiki.getColConstr()[i][j] == '^' || futoshiki.getColConstr()[i][j] == 'V'
                        || futoshiki.getColConstr()[i][j] == ' ') {
                    colFlag = true;
                } else {
                    colFlag = false;
                    break;
                }
            }
            if (!colFlag) {
                break;
            }
        }
        assertTrue(colFlag);

        //The following code tests that the row constraints align with valid values
        boolean rowFlag = true;
        for (int i = 0; i < futoshiki.getGridSize() - 1;i++) {
            for (int j = 0; j < futoshiki.getGridSize() - 2;j++) {
                if (futoshiki.getRowConstr()[i][j] == '<' || futoshiki.getRowConstr()[i][j] == '>'
                        || futoshiki.getRowConstr()[i][j] == ' ') {
                    rowFlag = true;
                } else {
                    rowFlag = false;
                    break;
                }
            }
            if (!rowFlag) {
                break;
            }
        }
        assertTrue(rowFlag);
    }

    public void testDisplayString() {
        String testPuzzle = "";
        for (int i = 0; i < futoshiki.getGridSize(); i++) {
            for (int l = 0; l < futoshiki.getGridSize(); l++) {
                testPuzzle += "--- ";
            }

            testPuzzle += "\n";

            for (int j = 0; j < futoshiki.getGridSize(); j++) {
                testPuzzle += "|" + futoshiki.getGrid()[i][j] + "|";
                if (j != futoshiki.getGridSize() - 1) {
                    if (i >= futoshiki.getGridSize() - 1) {
                        testPuzzle += futoshiki.getRowConstr()[i - 1][j];
                    } else {
                        testPuzzle += futoshiki.getRowConstr()[i][j];
                    }
                }
            }

            testPuzzle += "\n";

            for (int m = 0; m < futoshiki.getGridSize(); m++) {
                testPuzzle += "--- ";
            }

            testPuzzle += "\n";

            if (i < futoshiki.getGridSize() - 1) {
                for (int k = 0; k < futoshiki.getGridSize() - 1; k++) {
                    testPuzzle += " " + futoshiki.getColConstr()[i][k] + "  ";
                }
            }

            testPuzzle += "\n";
        }

        assertEquals(futoshiki.displayString(), testPuzzle);
    }

    public static void main(String[] args) {
        FutoshikiPuzzleTest test = new FutoshikiPuzzleTest(Integer.parseInt(args[0]));
        test.testSetSquare();
        test.testSetRowConstraint();
        test.testSetColConstraint();
        test.testFillPuzzle();
        test.testDisplayString();
    }
}
