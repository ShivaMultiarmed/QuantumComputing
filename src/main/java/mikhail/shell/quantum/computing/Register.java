package mikhail.shell.quantum.computing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends Vector {
    public Register(double K, double[] V) {
        super(K, V);
    }
    public static Register registerByString(String B)
    {
        Pattern coeffPattern = Pattern.compile("^([\\d.]+)");

        Matcher coeffMatcher = coeffPattern.matcher(B);
        final double k = coeffMatcher.find() ? Double.parseDouble(coeffMatcher.group(1)) : 1.0;

        Pattern registerStatesPattern = Pattern.compile("([+-]?)\\|([01]+)>");
        Matcher matcher = registerStatesPattern.matcher(B);

        double[] v = null;
        while(matcher.find())
        {
            String sign = matcher.group(1);
            String state = matcher.group(2);
            if (v == null)
                v = new double[(int) Math.pow(2, state.length())];
            int index = Integer.parseInt(state,2);
            if (sign == null || sign.isEmpty())
                sign = "+";
            v[index] = sign.equals("+") ? 1 : -1;
        }

        return new Register(k, v);
    }
    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append(K).append("(");

        for (int i = 0; i < M.length; i++)
            if (M[i][0]!=0)
            {
                if (builder.charAt(builder.length()-1) != '(')
                    if (M[i][0] > 0)
                        builder.append('+');
                    else
                        builder.append('-');
                else if (M[i][0] < 0)
                    builder.append('-');
                builder
                        .append("|")
                        .append(MathUtils.intToBinaryString(i, qubitsNumber()))
                        .append(">");
            }
        builder.append(")");
        return builder.toString();
    }
    public Register matrixToRegister(Matrix m)
    {
        return new Register(1, m.M[0]);
    }
    public int qubitsNumber()
    {
        return (int) MathUtils.log(2, M.length);
    }
}