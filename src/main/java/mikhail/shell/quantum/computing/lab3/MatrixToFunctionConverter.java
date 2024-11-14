package mikhail.shell.quantum.computing.lab3;

import mikhail.shell.quantum.computing.MathUtils;
import mikhail.shell.quantum.computing.Matrix;
import mikhail.shell.quantum.computing.MatrixOperations;

import java.util.Arrays;

public class MatrixToFunctionConverter {
    public double[][] generateResultMatrixAsArray(final int oldArgsNumber, final int[][] r)
    {
        return generateResultMatrixAsArray(oldArgsNumber, (int) Math.pow(2, oldArgsNumber), r);
    }
    public double[][] generateResultMatrixAsArray(final int oldArgsNumber, final int rowsNumber, final int[][] r)
    {
        final Matrix initialMatrix = new SimpleFunctionMatrix(oldArgsNumber, rowsNumber, r);
        final int funsNumber = r[0].length;
        final int newArgsNumber = oldArgsNumber + funsNumber;
        final double[][] intermediateResult = FunctionOperations.generateDoubleArguments(newArgsNumber);
        final int resultMatrixSize = (int) Math.pow(2, newArgsNumber);
        final double [][] resultMatrix = new double[resultMatrixSize][resultMatrixSize];
        for (int rowIndex = 0; rowIndex < intermediateResult.length; rowIndex++) { // проходим по каждой строке
            for (int colIndex = oldArgsNumber; colIndex < intermediateResult[rowIndex].length; colIndex++)
            {
                int y = (int) intermediateResult[rowIndex][colIndex];
                int f = getF(intermediateResult, rowIndex, newArgsNumber, initialMatrix, oldArgsNumber, colIndex);
                intermediateResult[rowIndex][colIndex] = y ^ f;
            }
            final int columnIndex = binaryArrayToDecimalInt(Arrays.stream(intermediateResult[rowIndex]).mapToInt(num -> (int) num).toArray());
            resultMatrix[rowIndex][columnIndex] = 1;
        }
        return resultMatrix;
    }
    public Matrix generateFunctionMatrix(final int[][] r)
    {
        final int argsNumber = MatrixOperations.getQubitDigits(r.length - 1);
        return generateFunctionMatrix(argsNumber, r.length, r);
    }
    public Matrix generateFunctionMatrix(final int argsNumber, final int[][] r)
    {
        return generateFunctionMatrix(argsNumber, (int) Math.pow(2, argsNumber), r);
    }
    public Matrix generateFunctionMatrix(final int argsNumber, final int rowsNumber, final int[][] r)
    {
        return new Matrix(1, generateResultMatrixAsArray(argsNumber,rowsNumber,r));
    }
    private int getF(double[][] result, int i, int newArgsNumber, final Matrix initialMatrix, final int oldArgsNumber, final int colIndex) {
        int k = 0; // выбирает строку из изначальной матрицы чтобы вычислить f
        int j;
        for (j = 0; j < oldArgsNumber; j++) // проходим по каждому аргументу
        {
            while (k < initialMatrix.M.length)
            {
                if (initialMatrix.M[k][j] == result[i][j])
                    break;
                // нашли искомую строку с результатом, где все аргументы соответвуют
                else
                    k++;
                // иначе берём следующую строку
            }
        }
        if (k == initialMatrix.M.length)
            k--;
        return (int) initialMatrix.M[k][colIndex];
    }

    public static int binaryArrayToDecimalInt(int [] binaryArray)
    {
        int result = 0;
        for (int i = 0; i <= binaryArray.length - 1; i++)
            result += (int) (binaryArray[binaryArray.length - 1 - i] * Math.pow(2, i));
        return result;
    }
}
