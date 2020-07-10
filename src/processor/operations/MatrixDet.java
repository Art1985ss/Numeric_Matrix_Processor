package processor.operations;

import processor.Matrix;
import processor.MatrixException;

import java.awt.*;

public class MatrixDet extends MatrixOperation {

    @Override
    public void execute() throws MatrixException {
        userInput();
        System.out.println("Result is :\n" + determinate(matrix1));
    }

    @Override
    protected void userInput() {
        inputMatrix1();
    }

    public double determinate(Matrix matrix) throws MatrixException {
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

    public Matrix cofactor(Matrix matrix) {
        if (matrix.getRows() != matrix.getColumns()) {
            throw new MatrixException();
        }

        Matrix matrixResult = new Matrix(matrix.getRows(), matrix.getColumns());
        for (int row = 0; row < matrix.getRows(); row++) {
            for (int col = 0; col < matrix.getColumns(); col++) {
                double d = Math.pow(-1, row + 1 + col + 1);
                double minor = 0;
                if (matrix.getColumns() < 4) {
                    minor = minor(createSubMatrix(matrix, row, col));
                } else {
                    minor = determinate(createSubMatrix(matrix, row, col));
                }
                Point p = new Point(row, col);
                matrixResult.setValue(p, d * minor);

            }
        }
        return matrixResult;
    }

    private double minor(Matrix matrix) {
        if (matrix.getRows() == 2) {
            return matrix.getValue(new Point(0, 0)) *
                    matrix.getValue(new Point(1, 1)) -
                    matrix.getValue(new Point(0, 1)) *
                            matrix.getValue(new Point(1, 0));
        }
        double sum = 0;
        for (int row = 0; row < matrix.getRows(); row++) {
            for (int col = 0; col < matrix.getColumns(); col++) {
                sum += minor(createSubMatrix(matrix, row, col));
            }
        }
        return sum;
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
