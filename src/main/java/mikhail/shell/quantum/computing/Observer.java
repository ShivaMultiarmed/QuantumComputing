package mikhail.shell.quantum.computing;

import java.util.*;

import static mikhail.shell.quantum.computing.MathUtils.intToBinaryString;

public class Observer {
    private final static Random random = new Random();
    private static double randomFraction()
    {
        return random.nextDouble(0,1);
    }
    public int observe(Qubit q)
    {
        final double a = q.K * q.M[0][0], b = q.K * q.M[1][0];
        final double p = Math.pow(a, 2); //  Вероятность нуля
        final boolean state = randomFraction() > p;
        q.M[0][0] = (state) ? 0 : 1;
        q.M[1][0] = (state) ? 1 : 0;
        q.K = 1.0;
        return q.M[0][0] == 0 ? 1 : 0;
    }
    public int observeH(Qubit q)
    {
        Qubit qH = Qubit.matrixToQubit(Matrix.hadamardMatrix().product(q));
        q.K = qH.K;
        q.M = qH.M;
        return observe(q);
    }
    public void observe(Register r)
    {
        final double percent = randomFraction();
        double minPercent = 0.0, maxPercent = 0.0;
        for (int i = 0, k = 0; i < r.M.length; i++) {
            if (r.M[i][0] != 0) {
                k++;
                minPercent = maxPercent;
                maxPercent = minPercent + Math.pow(r.M[i][0] * r.K, 2);
                r.M[i][0] =  (percent >= minPercent && percent < maxPercent) ? 1 : 0;
            }
        }
        r.K = 1;
    }
    public void observeQubitInRegister(Register r, int n)
    {
        double a = 0, b = 0;
        int qNum = r.qubitsNumber();
        for (int i = 0; i < r.M.length; i++)
        {
            if (r.M[i][0] != 0)
            {
                final String qubitString = intToBinaryString(i, qNum);
                if (qubitString.charAt(n) == '0')
                    b++;
                else
                    a++;
            }
        }
        a /= a + b; b = 1 - a;
        Qubit q = new Qubit(1.0, a, b);
        char result = Integer.toBinaryString(observe(q)).charAt(0);
        double c = 0;
        for (int i = 0; i< r.M.length; i++)
        {
            if (r.M[i][0] != 0)
            {
                final String qubitString = intToBinaryString(i, qNum);
                if (qubitString.charAt(n) == result)
                    c++;
                else
                    r.M[i][0] = 0;
            }
        }
        r.K = 1 / Math.sqrt(c);
    }
}
