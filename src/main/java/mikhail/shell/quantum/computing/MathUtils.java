package mikhail.shell.quantum.computing;

import java.util.Random;

public class MathUtils {
    private final static Random random = new Random(System.currentTimeMillis());
    public static double randomFraction()
    {
        return random.nextDouble(0,1);
    }
    public static double log(double base, double x)
    {
        return Math.log(x)/Math.log(base);
    }
    public static String intToBinaryString(int x, int digitNum)
    {
        final StringBuilder builder = new StringBuilder(Integer.toBinaryString(x));
        while (builder.length() < digitNum)
            builder.insert(0, '0');
        return builder.toString();
    }
    public static String doubleToBinaryString(double x, int digitNum)
    {
        return intToBinaryString((int) x, digitNum);
    }
}
