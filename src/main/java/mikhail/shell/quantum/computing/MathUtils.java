package mikhail.shell.quantum.computing;

public class MathUtils {
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
}
