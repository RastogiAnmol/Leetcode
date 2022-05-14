package wesco;

public class MatrixMultiplication {
    public int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2, int[][] matrix3){
        int[][] result = new int[3][3];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] * matrix2[i][j] * matrix3[i][j];
            }
        }
        return result;
    }
    public void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][3];
        int[][] matrix3 = new int[3][3];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = i+j;
                matrix2[i][j] = i+j;
                matrix3[i][j] = i+j;
            }
        }
        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
        int[][] result = matrixMultiplication.multiplyMatrix(matrix1, matrix2, matrix3);
        matrixMultiplication.printMatrix(result);
    }
}
