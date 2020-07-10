package processor.operations;

import processor.Matrix;
import processor.MatrixException;

import java.awt.*;

public class MatrixMultiplication extends MatrixOperation {
    @Override
    public void execute() {
        userInput();
        try{
            System.out.println("The multiplication result is:");
            System.out.println(multiply());
        }catch (MatrixException e){
            System.out.println(e.getMessage());
        }
    }

    private Matrix multiply() {
        if (matrix1.getColumns() != matrix2.getRows()) {
            throw new MatrixException();
        }
        Matrix matrixResult = new Matrix(matrix1.getRows(), matrix2.getColumns());
        for (int row1 = 0; row1 < matrix1.getRows(); row1++) {
            for (int col2 = 0; col2 < matrix2.getColumns(); col2++) {
                Point p = new Point(row1, col2);
                double sum = 0;
                for (int row2 = 0; row2 < matrix2.getRows(); row2++) {
                    Point p1 = new Point(row1, row2);
                    Point p2 = new Point(row2, col2);
                    sum += matrix1.getValue(p1) * matrix2.getValue(p2);
                }
                matrixResult.setValue(p, sum);
            }
        }
        return matrixResult;
    }
}
