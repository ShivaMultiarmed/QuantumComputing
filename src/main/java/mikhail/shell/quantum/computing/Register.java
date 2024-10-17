package mikhail.shell.quantum.computing;

import java.util.IllegalFormatException;

public class Register extends Vector {
    public Register(double K, double[] V) {
        super(K, V);
    }
    @Override
    public String toString()
    {
        final int qubitsNumber = (int) MathUtils.log(2, M.length);

        final StringBuilder builder = new StringBuilder();
        builder.append(K+"(");

        for (int i = 0; i < M.length; i++)
        {
            if (M[i][0]==1)
            {
                if (i!=0)
                    builder.append('+');
                builder.append("|" + MathUtils.intToBinaryString(i, qubitsNumber) + ">");
            }

        }


        builder.append(")");
        return builder.toString();
    }
}
