package mikhail.shell.quantum.computing.lab3;

import mikhail.shell.quantum.computing.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RemainderCalculator {
    private final int a, m;
    private final Matrix f;

    public RemainderCalculator(final int a, final int m)
    {
        this.a = a;
        this.m = m;
        final int[] remainders = evaluateRemainders();
        final int qubitsNumberForRemainder = MatrixOperations.getQubitDigits(m);

        int maxArgument = remainders[remainders.length - 1];
        int argumentsQubitsNumber = MatrixOperations.getQubitDigits(maxArgument);
        final int[][] functions = new int[maxArgument + 1][qubitsNumberForRemainder];
        for (int i = 0; i < functions.length; i++) {
            int r = remainders[i];
            for (int j = functions[i].length - 1; j >= 0; j--) {
                functions[i][j] = r % 2;
                r /= 2;
            }
        }
        f = new MatrixToFunctionConverter().generateFunctionMatrix(argumentsQubitsNumber, functions);
    }
    private int getRemainder(final int x)
    {
        return ((int) Math.pow(a, x)) % m;
    }
    private int[] evaluateRemainders()
    {
        final List<Integer> remainders = new LinkedList<>();
        int i = 0;
        int remainder = 1;
        do {
            remainders.add(remainder);
            remainder = getRemainder(++i);
        } while(remainder != 1 || 0 == i - 1);
        return remainders.stream().mapToInt(num -> num).toArray();
    }
    public int evaluateRemainder(final int x)
    {
        final int[] argumentsRow = MathUtils.intToBinaryArray(x);
        final int remainderQubitsNum = MatrixOperations.getQubitDigits(m - 1);
        final Qubit[] row = new Qubit[argumentsRow.length + remainderQubitsNum];
        for (int i = 0; i < row.length; i++)
        {
            if (i < argumentsRow.length)
                row[i] = argumentsRow[i] == 0 ? Qubit.zero() : Qubit.one();
            else
                row[i] = Qubit.zero();
        }
        Matrix m = row[0];
        for (int i = 1; i < row.length;i++)
            m = m.tensorProduct(row[i]);
        final Register register = Register.matrixToRegister(m);
        final Register newRegister = Register.matrixToRegister(f.product(register));
        int decimalResult = 0;
        for (int i = 0; i < newRegister.M.length; i++) {
            if (newRegister.M[i][0] == 1)
            {
                decimalResult = i;
                break;
            }
        }
        return decimalResult & (int) (Math.pow(2, remainderQubitsNum) - 1);
    }
}
