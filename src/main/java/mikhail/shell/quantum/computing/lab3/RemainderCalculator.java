package mikhail.shell.quantum.computing.lab3;

import mikhail.shell.quantum.computing.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RemainderCalculator {
    private final int a, m;
    private final Matrix f;
    private final int argumentsQubitsNumber, remainderQubitsNum;

    public RemainderCalculator(final int a, final int m)
    {
        this.a = a;
        this.m = m;
        final int[] remainders = evaluateRemainders();
        remainderQubitsNum = MatrixOperations.getQubitDigits(m);

        final int maxArgument = remainders.length - 1;
        argumentsQubitsNumber = MatrixOperations.getQubitDigits(maxArgument);
        final int rowsNumber = remainders.length;
        final int[][] functions = new int[rowsNumber][remainderQubitsNum];
        for (int i = 0; i < rowsNumber; i++) {
            int r = remainders[i % remainders.length];
            for (int j = functions[i].length - 1; j >= 0; j--) {
                functions[i][j] = r % 2;
                r /= 2;
            }
        }
        f = new MatrixToFunctionConverter().generateFunctionMatrix(argumentsQubitsNumber, rowsNumber, functions);
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
        final int remainderQubitsNum = MatrixOperations.getQubitDigits(m - 1);
        final Register register = inputToRegister(x);
        System.out.println(register);
        final Register newRegister = Register.matrixToRegister(f.product(register));
        System.out.println(f);
        System.out.println(newRegister);
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
    private Register inputToRegister(final int x)
    {
        final Qubit[] row = inputToQubitArray(x, remainderQubitsNum);
        Matrix m = row[0];
        for (int i = 1; i < row.length;i++)
            m = m.tensorProduct(row[i]);
        return Register.matrixToRegister(m);
    }
    public Register evaluateWholeFunction()
    {
        final Qubit[] row = new Qubit[argumentsQubitsNumber + remainderQubitsNum];
        for (int i = 0; i < row.length; i++) {
            if (i < argumentsQubitsNumber)
                row[i] = Qubit.superPosPlus();
            else
                row[i] = Qubit.zero();
        }
        Matrix m = row[0];
        for (int i = 1; i < row.length;i++)
            m = m.tensorProduct(row[i]);
        final var superPosRegister = Register.matrixToRegister(m);
        return Register.matrixToRegister(f.product(superPosRegister));
    }
    private Qubit[] inputToQubitArray(final int x, final int remainderQubitsNum)
    {
        final int[] argumentsRow = MathUtils.intToBinaryArray(x, argumentsQubitsNumber);

        final Qubit[] row = new Qubit[argumentsRow.length + remainderQubitsNum];
        for (int i = 0; i < row.length; i++)
        {
            if (i < argumentsRow.length)
                row[i] = argumentsRow[i] == 0 ? Qubit.zero() : Qubit.one();
            else
                row[i] = Qubit.zero();
        }
        return row;
    }
}
