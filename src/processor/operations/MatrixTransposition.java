package processor.operations;

import processor.Matrix;
import processor.MatrixException;

import java.awt.*;

public class MatrixTransposition extends MatrixOperation {
    private int selection;

    @Override
    public void execute() throws MatrixException {
        userInput();
        System.out.println(transpose(matrix1, selection));
    }


    private void printOptions() {
        String text = "1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" +
                "Your choice:";
        System.out.println(text);
    }

    protected void userInput() {
        printOptions();
        selection = scanner.nextInt();
        inputMatrix1();
    }

    public Matrix transpose(Matrix matrix, int mode) {
        if (mode < 1 || mode > 4) {
            throw new MatrixException();
        }
        Matrix matrixResult;
        switch (mode) {
            case 1:
            case 2:
                matrixResult = new Matrix(matrix.getColumns(), matrix.getRows());
                break;
            case 3:
            case 4:
            default:
                matrixResult = new Matrix(matrix.getRows(), matrix.getColumns());
        }
        new Matrix(matrix.getRows(), matrix.getColumns());
        for (int row = 0; row < matrix.getRows(); row++) {
            for (int col = 0; col < matrix.getColumns(); col++) {
                Point p1 = new Point(row, col);
                Point p = new Point(row, col);
                switch (mode) {
                    case 1:
                        p = new Point(col, row);
                        break;
                    case 2:
                        p = new Point(matrixResult.getColumns() - 1 - col,
                                matrixResult.getRows() - 1 - row);
                        break;
                    case 3:
                        p = new Point(row, matrixResult.getColumns() - 1 - col);
                        break;
                    case 4:
                        p = new Point(matrixResult.getRows() - 1 - row, col);
                        break;
                    default:
                }
                matrixResult.setValue(p, matrix.getValue(p1));

            }
        }
        return matrixResult;
    }
}
