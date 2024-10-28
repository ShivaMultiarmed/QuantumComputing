package mikhail.shell.quantum.computing;

public class Qubit extends Register{
    public Qubit(double K, double a, double b)
    {
        super(K, new double[] {a, b});
    }
    public static Qubit matrixToQubit(Matrix m)
    {
        return new Qubit(m.K, m.M[0][0], m.M[1][0]);
    }
    public static Qubit zero() {
        return new Qubit(1, 1,0);
    }
    public static Qubit one() {
        return new Qubit(1, 0,1);
    }
    public static Qubit superPosPlus() {
        return new Qubit(1/Math.sqrt(2), 1,1);
    }
    public static Qubit superPosMinus() {
        return new Qubit(1/Math.sqrt(2), 1,-1);
    }
}
