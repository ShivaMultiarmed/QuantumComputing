package mikhail.shell.quantum.computing.lab3;

import mikhail.shell.quantum.computing.MathUtils;
import mikhail.shell.quantum.computing.Matrix;

public class SimpleFunctionMatrix extends Matrix {
    public SimpleFunctionMatrix(final int argsNumber, int[][] results)
    {
        this(argsNumber, (int) Math.pow(2, argsNumber), results);
    }
    public SimpleFunctionMatrix(final int argsNumber, final int rowsNumber, int[][] results)
    {
        super(1, null);
        final int[][] args = FunctionOperations.generateArguments(argsNumber, rowsNumber);
        final int funsNumber = results[0].length;
        final double[][] function = new double[rowsNumber][argsNumber + funsNumber];
        for (int i = 0; i < rowsNumber; i++)
        {
            for (int j = 0; j < function[i].length; j++)
            {
                if (j < argsNumber)
                    function[i][j] = args[i][j];
                else
                    function[i][j] = results[i][j - argsNumber];
            }
        }
        M = function;
    }
}
