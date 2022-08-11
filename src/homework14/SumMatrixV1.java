package homework14;

public class SumMatrixV1 {
    public Integer execute(String[][] matrix, int size) throws MyArraySizeException, MyArrayDataException {
        if (matrix.length != size) {
            throw new MyArraySizeException(matrix.length, size);
        }

        int sum = 0;
        int value;
        for (int row = 0; row < matrix.length; row++) {
            if(matrix[row].length != size){
                throw new MyArraySizeException(matrix[row].length, size);
            }
            for (int column = 0; column < matrix[row].length; column++) {
                try {
                    value = Integer.parseInt(matrix[row][column]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(row, column);
                }
                sum += value;
            }
        }
        return sum;
    }
}
