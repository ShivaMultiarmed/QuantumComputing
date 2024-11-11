package mikhail.shell.quantum.computing.lab3;

import mikhail.shell.quantum.computing.MathUtils;
import mikhail.shell.quantum.computing.Matrix;

public class FunctionMatrix extends Matrix {
    public FunctionMatrix(int[] m) {
        super(1, null);
        int argsNumber = (int) MathUtils.log(2, m.length);
        int[][] args = FunctionOperations.generateArguments(argsNumber);
        double[][] function = new double[m.length][argsNumber + 1];
        for (int i = 0; i < function.length; i++)
        {
            for (int j = 0; j < function[i].length - 1; j++)
            {
                function[i][j] = args[i][j];
            }
            function[i][function[i].length - 1] = m[i];
        }
        M = function;
    }
}
