package processor.operations;

import processor.Matrix;
import processor.MatrixException;

import java.util.Scanner;

public abstract class MatrixOperation {
    protected Matrix matrix1;
    protected Matrix matrix2;
    protected final Scanner scanner = new Scanner(System.in);

    public abstract void execute() throws MatrixException;


    protected void userInput() {
        inputMatrix1();
        inputMatrix2();
    }

    protected void inputMatrix1() {
        System.out.println("Enter size of first matrix:");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        matrix1 = new Matrix(rows, columns);
        System.out.println("Enter first matrix:");
        matrix1.userInput();
    }

    protected void inputMatrix2() {
        System.out.println("Enter size of second matrix:");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        matrix2 = new Matrix(rows, columns);
        System.out.println("Enter second matrix:");
        matrix2.userInput();
    }

    public static MatrixOperation create(int selected) {
        switch (selected) {
            case 1:
                return new MatrixAddition();
            case 2:
                return new MatrixMultiplicationToConstant();
            case 3:
                return new MatrixMultiplication();
            case 4:
                return new MatrixTransposition();
            case 5:
                return new MatrixDet();
            case 6:
                return new MatrixInverse();
            default:
                throw new MatrixException();
        }
    }
}
