package mikhail.shell.quantum.computing.lab3;

import mikhail.shell.quantum.computing.MathUtils;
import mikhail.shell.quantum.computing.Matrix;

public class SimpleFunctionMatrix extends Matrix {
    public SimpleFunctionMatrix(int[][] results) {
        super(1, null);
        final int argsNumber = (int) MathUtils.log(2, results.length);
        final int funsNumber = results[0].length;
        int[][] args = FunctionOperations.generateArguments(argsNumber);
        final double[][] function = new double[results.length][argsNumber + funsNumber];
        for (int i = 0; i < function.length; i++)
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
