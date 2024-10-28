package mikhail.shell.quantum.computing;

public class MatrixOperations {

    public static double[][] product(double[][] A, double[][] B) {
        int rowsFirstMatrix = A.length;
        int colsFirstMatrix = A[0].length;
        int colsSecondMatrix = B[0].length;

        double[][] result = new double[rowsFirstMatrix][colsSecondMatrix];

        for (int i = 0; i < rowsFirstMatrix; i++) {
            for (int j = 0; j < colsSecondMatrix; j++) {
                for (int k = 0; k < colsFirstMatrix; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }
    public static double[][] tensorProduct(double[][] A, double [][] B)
    {
        final int rowsA = A.length, colsA = A[0].length;
        final int rowsB = B.length, colsB = B[0].length;
        double[][] result = new double[rowsA * rowsB][colsA * colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                for (int x = 0; x < rowsB; x++)
                {
                    for (int y = 0; y < colsB; y++)
                    {
                        result[i * rowsB + x][j * colsB + y] = A[i][j] * B[x][y];
                    }
                }
            }
        }
        return  result;
    }
}
