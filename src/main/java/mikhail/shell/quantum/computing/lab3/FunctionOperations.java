package mikhail.shell.quantum.computing.lab3;

import java.util.Arrays;

public class FunctionOperations {
    public static int[][] generateArguments(final int n) // x1, x2, y
    {
        final int[][] args = new int[(int) Math.pow(2, n)][n];

        for (int i = 0; i < args.length; i++) {
            int x = i;
            for (int j = n - 1; j >= 0; j--)
            {
                args[i][j] = x % 2;
                x /= 2;
            }
        }
        return args;
    }
    public static double[][] generateDoubleArguments(final int n) {
        return Arrays.stream(generateArguments(n)).map( row ->
                    Arrays.stream(row).mapToDouble(cell -> 1.0 * cell).toArray()
        ).toArray(double[][]::new);
    }
}
