package processor.operations;

import processor.Matrix;
import processor.MatrixException;

import java.awt.*;

public class MatrixAddition extends MatrixOperation {


    @Override
    public void execute() throws MatrixException {
        userInput();
        System.out.println("Addition result is :\n" + sum());
    }

    private Matrix sum() throws MatrixException {
        if (!matrix1.isSameSize(matrix2)) {
            throw new MatrixException();
        }
        Matrix matrixSum = new Matrix(matrix1.getRows(), matrix1.getColumns());
        for (int row = 0; row < matrix1.getRows(); row++) {
            for (int col = 0; col < matrix1.getColumns(); col++) {
                Point p = new Point(row, col);
                matrixSum.setValue(p, matrix1.getValue(p) + matrix2.getValue(p));
            }
        }
        return matrixSum;
    }
}
