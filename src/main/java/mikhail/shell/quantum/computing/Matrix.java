package mikhail.shell.quantum.computing;

import java.util.Arrays;


public class Matrix {
    public double K;
    public final double[][] M;
    public Matrix(double K, double[][] M)
    {
        this.K = K;
        this.M = M;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Matrix))
            return false;
        else {
            Matrix m = (Matrix) obj;
            return K == m.K && Arrays.deepEquals(M, m.M);
        }

    }
    public Matrix product(Matrix other) {
        return new Matrix(K * other.K, MatrixOperations.product(M, other.M));
    }
    public Matrix tensorProduct(Matrix other) {
        return new Matrix(K * other.K, MatrixOperations.tensorProduct(M, other.M));
    }
    public static Matrix not() {
        return new Matrix(1, new double[][]{{0.0,1.0},{1.0,0.0}});
    }
    public static Matrix identityMatrix(int n)
    {
        final double[][] result = new double[n][n];
        for (int i =0; i<n;i++)
            for (int j =0; j<n;j++)
                result[i][j] = (i==j) ? 1 : 0;
        return new Matrix(1, result);
    }
    public static Matrix nullMatrix(int n)
    {
        final double[][] result = new double[n][n];
        for (int i =0; i<n;i++)
            for (int j =0; j<n;j++)
                result[i][j] = 0;
        return new Matrix(1, result);
    }
    public static Matrix controlledMatrix(Matrix m)
    {
        final int d = m.M.length; // сторона старой матрицы
        final double[][] identityMatrix = identityMatrix(d).M;
        final double[][] nullMatrix = nullMatrix(d).M;
        double[][] result = new double[d * 2][d * 2];
        for (int i = 0; i < d; i++)
        {
            for (int j =0; j< d; j++)
            {
                result[i][j] = identityMatrix[i][j];
                result[i][j+d] = nullMatrix[i][j];
                result[i+d][j] = nullMatrix[i][j];
                result[i+d][j+d] = m.M[i][j];
            }
        }
        return new Matrix(1, result);
    }
}
