package processor;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Matrix {
    private final int rows;
    private final int columns;
    private final double[][] matrix;

    private final Scanner scanner = new Scanner(System.in);

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }

    public void userInput() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                double in = scanner.nextDouble();
                matrix[row][col] = in;
            }
        }
    }

    public boolean isSameSize(Matrix matrix) {
        if (matrix.getColumns() != this.columns) {
            return false;
        }
        return matrix.getRows() == this.rows;
    }

    public double getValue(Point p) {
        return matrix[p.x][p.y];
    }

    public void setValue(Point p, double value) {
        matrix[p.x][p.y] = value;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                String s = String.format("%-15.2f", matrix[row][col]);
                sb.append(s);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return rows == matrix1.rows &&
                columns == matrix1.columns &&
                Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }
}
