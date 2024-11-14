package mikhail.shell.quantum.computing.lab3;

import mikhail.shell.quantum.computing.Matrix;

import java.util.Arrays;

public class FunctionOperations {
    public static int[][] generateArguments(final int argsNumber) {
        return generateArguments(argsNumber, (int) Math.pow(2, argsNumber));
    }
    public static int[][] generateArguments(final int argsNumber, final int rowsNumber)
    {
        final int[][] args = new int[rowsNumber][argsNumber];

        for (int i = 0; i < rowsNumber; i++) {
            int x = i;
            for (int j = argsNumber - 1; j >= 0; j--)
            {
                args[i][j] = x % 2;
                x /= 2;
            }
        }
        return args;
    }
    public static double[][] generateDoubleArguments(final int argsNumber) {
        return generateDoubleArguments(argsNumber, (int) Math.pow(2, argsNumber));
    }
    public static double[][] generateDoubleArguments(final int argsNumber, final int rowsNumber) {
        return Arrays.stream(generateArguments(argsNumber, rowsNumber)).map( row ->
                    Arrays.stream(row).mapToDouble(cell -> 1.0 * cell).toArray()
        ).toArray(double[][]::new);
    }
}
