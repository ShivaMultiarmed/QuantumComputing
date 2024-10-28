package mikhail.shell.quantum.computing;

public class Register extends Vector {
    public Register(double K, double[] V) {
        super(K, V);
    }
    @Override
    public String toString()
    {

        final StringBuilder builder = new StringBuilder();
        builder.append(K).append("(");

        for (int i = 0; i < M.length; i++)
            if (M[i][0]==1)
            {
                if (builder.charAt(builder.length()-1) != '(')
                    builder.append('+');
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
