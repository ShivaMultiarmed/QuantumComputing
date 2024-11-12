package mikhail.shell.quantum.computing.lab3;

import mikhail.shell.quantum.computing.Matrix;
import mikhail.shell.quantum.computing.Vector;

import java.util.Arrays;

public class MatrixToFunctionConverter {
    public double[][] generateResultMatrixAsArray(final int[] r)
    {
        final Matrix initialMatrix = new FunctionMatrix(r);
        int newArgsNumber = initialMatrix.M[0].length;
        double[][] intermediateResult = FunctionOperations.generateDoubleArguments(newArgsNumber);
        final int resultMatrixSize = (int) Math.pow(2, newArgsNumber);
        double [][] resultMatrix = new double[resultMatrixSize][resultMatrixSize];
        for (int rowIndex = 0; rowIndex < intermediateResult.length; rowIndex++) { // проходим по каждой строке
            int y = (int) intermediateResult[rowIndex][newArgsNumber - 1];
            int f = getF(intermediateResult, rowIndex, newArgsNumber, initialMatrix);
            intermediateResult[rowIndex][newArgsNumber - 1] = y ^ f;
            final int colIndex = binaryArrayToDecimalInt(Arrays.stream(intermediateResult[rowIndex]).mapToInt(num -> (int) num).toArray());
            resultMatrix[rowIndex][colIndex] = 1;
        }
        return resultMatrix;
    }
    public Matrix generateFunctionMatrix(final int[] r)
    {
        return new Matrix(1, generateResultMatrixAsArray(r));
    }

    private int getF(double[][] result, int i, int newArgsNumber, final Matrix initialMatrix) {
        int k = 0; // выбирает строку из изначальной матрицы чтобы вычислить f
        for (int j = 0; j < result[i].length - 1; j++) // проходим по каждому аргументу
        {
            while (k <= initialMatrix.M.length)
            {
                if (initialMatrix.M[k][j] == result[i][j]) // нашли искомую строку с результатом, где все аргументы соответвуют
                    break;
                k++; // иначе берём следующую строку
            }
        }
        return (int) initialMatrix.M[k][newArgsNumber - 1];
    }

    public static int binaryArrayToDecimalInt(int [] binaryArray)
    {
        int result = 0;
        for (int i = 0; i <= binaryArray.length - 1; i++)
            result += (int) (binaryArray[binaryArray.length - 1 - i] * Math.pow(2, i));
        return result;
    }
}
