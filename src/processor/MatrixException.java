package processor;

public class MatrixException extends RuntimeException {
    public MatrixException(String message) {
        super(message);
    }

    public MatrixException(){
        super("ERROR");
    }
}
