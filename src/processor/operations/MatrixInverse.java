package processor.operations;

import processor.Matrix;
import processor.MatrixException;

public class MatrixInverse extends MatrixOperation {
    @Override
    public void execute() throws MatrixException {
        userInput();
        System.out.println("The result is: \n" + inverse());
    }

    @Override
    protected void userInput() {
        inputMatrix1();
    }

    private Matrix inverse() throws MatrixException {
        MatrixDet matrixDet = new MatrixDet();
        double det = matrixDet.determinate(matrix1);
        if (det == 0) {
            throw new MatrixException();
        }
        matrix1 = matrixDet.cofactor(matrix1);
        MatrixTransposition matrixTransposition = new MatrixTransposition();
        matrix1 = matrixTransposition.transpose(matrix1, 1);
        MatrixMultiplicationToConstant matrixMultiplicationToConstant =
                new MatrixMultiplicationToConstant();
        matrix1 = matrixMultiplicationToConstant.multiplyByNumber(matrix1, 1 / det);
        return matrix1;

    }
}
