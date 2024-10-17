package mikhail.shell.quantum.computing;

import java.util.Random;

public class Observer {
    private final static Random random = new Random();
    private static double randomFraction()
    {
        return random.nextDouble(0,1);
    }
    public void observe(Qubit q)
    {
        final double a = q.K * q.M[0][0], b = q.K * q.M[1][0];
        final double p = Math.pow(a, 2); //  Вероятность нуля
        final boolean state = randomFraction() > p;
        q.M[0][0] = (state) ? 0 : 1;
        q.M[1][0] = (state) ? 1 : 0;
        q.K = 1.0;
    }
}
