package processor.operations;

import processor.Matrix;
import processor.MatrixException;

import java.awt.*;

public class MatrixMultiplicationToConstant extends MatrixOperation {
    private double number;

    @Override
    public void execute() throws MatrixException {
        userInput();
        System.out.println("Multiplication to constant result is :");
        System.out.println(multiplyByNumber(matrix1, number));
    }

    @Override
    protected void userInput() {
        inputMatrix1();
        System.out.println("Enter number:");
        number = scanner.nextDouble();
    }

    public Matrix multiplyByNumber(Matrix matrix, double number) {
        Matrix matrixResult = new Matrix(matrix.getRows(), matrix.getColumns());
        for (int row = 0; row < matrix.getRows(); row++) {
            for (int col = 0; col < matrix.getColumns(); col++) {
                Point p = new Point(row, col);
                matrixResult.setValue(p, matrix.getValue(p) * number);
            }
        }
        return matrixResult;
    }
}
