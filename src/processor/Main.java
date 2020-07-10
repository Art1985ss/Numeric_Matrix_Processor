package processor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        try {
            LogManager.getLogManager().readConfiguration(
                    new FileInputStream("./Numeric Matrix Processor/task/src/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
    }


    public static void main(String[] args) {
        ConsoleOptions consoleOptions = new ConsoleOptions();
        consoleOptions.initConsole();
    }
}