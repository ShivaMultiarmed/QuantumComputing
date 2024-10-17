package mikhail.shell.quantum.computing;

import java.util.Arrays;


public class Matrix {
    public final double K;
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
}
