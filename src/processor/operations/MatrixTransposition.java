package processor.operations;

import processor.Matrix;
import processor.MatrixException;

import java.awt.*;

public class MatrixTransposition extends MatrixOperation {
    private int selection;

    @Override
    public void execute() {
        userInput();
        try {
            System.out.println(transpose());
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
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

    private Matrix transpose() {
        if (selection < 1 || selection > 4) {
            throw new MatrixException();
        }
        Matrix matrix;
        switch (selection) {
            case 1:
            case 2:
                matrix = new Matrix(matrix1.getColumns(), matrix1.getRows());
                break;
            case 3:
            case 4:
            default:
                matrix = new Matrix(matrix1.getRows(), matrix1.getColumns());
        }
        new Matrix(matrix1.getRows(), matrix1.getColumns());
        for (int row = 0; row < matrix1.getRows(); row++) {
            for (int col = 0; col < matrix1.getColumns(); col++) {
                Point p1 = new Point(row, col);
                Point p = new Point(row, col);
                switch (selection) {
                    case 1:
                        p = new Point(col, row);
                        break;
                    case 2:
                        p = new Point(matrix.getColumns() - 1 - col,
                                matrix.getRows() - 1 - row);
                        break;
                    case 3:
                        p = new Point(row, matrix.getColumns() - 1 - col);
                        break;
                    case 4:
                        p = new Point(matrix.getRows() - 1 - row, col);
                        break;
                    default:
                }
                matrix.setValue(p, matrix1.getValue(p1));

            }
        }
        return matrix;
    }
}
