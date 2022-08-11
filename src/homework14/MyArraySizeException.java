package homework14;

public class MyArraySizeException extends Exception{
    public MyArraySizeException(int errsize, int size){
        super ("Invalid size of matrix: " + errsize + " must: " + size);
    }
}
