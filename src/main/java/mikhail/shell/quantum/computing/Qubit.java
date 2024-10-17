package mikhail.shell.quantum.computing;

public class Qubit extends Vector{
    public Qubit(double K, double a, double b)
    {
        super(K, new double[] {a, b});
    }
}
