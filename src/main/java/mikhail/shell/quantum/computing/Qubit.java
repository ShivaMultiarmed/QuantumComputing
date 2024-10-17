package mikhail.shell.quantum.computing;

public class Qubit extends Vector{
    public Qubit(double K, double a, double b)
    {
        super(K, new double[] {a, b});
    }
    public static Qubit matrixToQubit(Matrix m)
    {
        return new Qubit(m.K, m.M[0][0], m.M[1][0]);
    }
}
