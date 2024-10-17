package mikhail.shell.quantum.computing;


public class Vector extends Matrix {

    public Vector(double K, double[] V) {
        super(K, vectorToMatrix(V));
    }
    public static Vector matrixToVector(Matrix m)
    {
        return new Vector(m.K, m.M[0]);
    }
    public static double[][] vectorToMatrix(double[] V)
    {
        final double[][] matrix = new double[V.length][1];
        for (int i = 0; i< matrix.length;i++)
            matrix[i][0] = V[i];
        return matrix;
    }
}
