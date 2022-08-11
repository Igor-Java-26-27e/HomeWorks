package homework14;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int row, int column){
        super("Incorrect number format in row: " + row + ", column: "+column);
    }
}
