package processor.operations;

import processor.Matrix;

import java.awt.*;

public class MatrixMultiplicationToConstant extends MatrixOperation {
    private double number;

    @Override
    public void execute() {
        userInput();
        System.out.println("Multiplication to constant result is :");
        System.out.println(multiplyByNumber());
    }

    @Override
    protected void userInput() {
        inputMatrix1();
        System.out.println("Enter number:");
        number = scanner.nextDouble();
    }

    private Matrix multiplyByNumber() {
        Matrix matrixResult = new Matrix(matrix1.getRows(), matrix1.getColumns());
        for (int row = 0; row < matrix1.getRows(); row++) {
            for (int col = 0; col < matrix1.getColumns(); col++) {
                Point p = new Point(row, col);
                matrixResult.setValue(p, matrix1.getValue(p) * number);
            }
        }
        return matrixResult;
    }
}
