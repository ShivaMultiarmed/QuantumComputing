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
    public static int[] intToBinaryArray(int x, int num)
    {
        //final int num = MatrixOperations.getQubitDigits(x);
        final int[] arr = new int[num];
        for (int i = num - 1; i >= 0; i--) {
            arr[i] = x % 2;
            x /= 2;
        }
        return arr;
    }
    public static int binaryArrayToInt(int a[])
    {
        int r = 0;
        for (int i = 0; i< a.length; i++)
            r += (int) (a[a.length - 1 - i] * Math.pow(2, i));
        return r;
    }
}
