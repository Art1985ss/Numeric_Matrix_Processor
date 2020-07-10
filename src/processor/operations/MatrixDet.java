package processor.operations;

import processor.Matrix;
import processor.MatrixException;

import java.awt.*;

public class MatrixDet extends MatrixOperation {
    @Override
    public void execute() {
        userInput();
        try {
            System.out.println("Result is :\n" + determinate(matrix1));
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void userInput() {
        inputMatrix1();
    }

    private double determinate(Matrix matrix) {
        if (matrix.getRows() != matrix.getColumns()) {
            throw new MatrixException();
        }
        if (matrix.getRows() == 2) {
            return minor(matrix);
        }
        double sum = 0;
        for (int col = 0; col < matrix.getColumns(); col++) {
            double det = determinate(createSubMatrix(matrix, 0, col));
            sum += matrix.getValue(new Point(0, col)) * Math.pow(-1.0, col + 2) * det;
        }
        return sum;
    }

    private double minor(Matrix matrix) {
        if (matrix.getRows() > 2) {
            throw new MatrixException();
        }
        return matrix.getValue(new Point(0, 0)) *
                matrix.getValue(new Point(1, 1)) -
                matrix.getValue(new Point(0, 1)) *
                        matrix.getValue(new Point(1, 0));
    }

    private Matrix createSubMatrix(Matrix matrix, int row, int col) {
        Matrix newMatrix = new Matrix(matrix.getRows() - 1,
                matrix.getColumns() - 1);
        int rows = 0;
        for (int r = 0; r < matrix.getRows(); r++) {
            int columns = 0;
            if (r == row) {
                rows++;
                continue;
            }
            for (int c = 0; c < matrix.getColumns(); c++) {
                if (c == col) {
                    columns++;
                    continue;
                }
                Point p = new Point(r, c);
                Point pn = new Point(r - rows, c - columns);
                newMatrix.setValue(pn, matrix.getValue(p));
            }
        }
        return newMatrix;
    }
}
