package processor;

import processor.operations.MatrixOperation;

import java.util.Scanner;

public class ConsoleOptions {
    private final Scanner scanner = new Scanner(System.in);
    private static final String OPTION_TEXT = "1. Add matrices\n" +
            "2. Multiply matrix to a constant\n" +
            "3. Multiply matrices\n" +
            "4. Transpose matrix\n" +
            "5. Calculate a determinant\n" +
            "6. Inverse matrix\n" +
            "0. Exit\n" +
            "Your choice:";


    private boolean userInput() {
        int selected = scanner.nextInt();
        if (selected == 0) {
            return false;
        }
        try {
            MatrixOperation operation = MatrixOperation.create(selected);
            operation.execute();
        } catch (MatrixException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public void initConsole(){
        System.out.println(OPTION_TEXT);
        while (userInput()){
            System.out.println(OPTION_TEXT);
        }
    }


}
