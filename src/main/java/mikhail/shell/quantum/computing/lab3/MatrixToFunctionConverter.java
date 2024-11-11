package mikhail.shell.quantum.computing.lab3;

import mikhail.shell.quantum.computing.Matrix;

public class MatrixToFunctionConverter {
    private Matrix m;
    public MatrixToFunctionConverter(final int[] r)
    {
        m = new FunctionMatrix(r);
    }
    public double[][] generateResultMatrix()
    {
        int newArgsNumber = m.M[0].length;
        double[][] result = FunctionOperations.generateDoubleArguments(newArgsNumber);
        for (int i = 0; i < result.length; i++) {
            int y = (int) result[i][newArgsNumber - 1];
            int k = 0;
            for (int j = 0; j < result[i].length - 1; j++)
            {
                while (k <= m.M.length)
                {
                    if (m.M[k][j] == result[i][j])
                        break;
                    k++;
                }
            }
            int f = (int) m.M[k][newArgsNumber - 1];
            result[i][newArgsNumber - 1] = y ^ f;
        }
        return result;
    }
}
