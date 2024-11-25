package mikhail.shell.quantum.computing;

import mikhail.shell.quantum.computing.lab3.MatrixToFunctionConverter;
import mikhail.shell.quantum.computing.lab3.RemainderCalculator;
import org.junit.jupiter.api.Test;

public class ParallelismTests {
    @Test
    void testEvaluatingFunctionInAllPoints()
    {
        final Qubit x1 = Qubit.superPosPlus(), x2 = Qubit.superPosPlus(), y1 = Qubit.zero();
        final Register initial = Register.matrixToRegister(x1.tensorProduct(x2).tensorProduct(y1));
        System.out.println(initial);
        final int[][] f = {{0}, {0}, {0}, {1}};
        var converter = new MatrixToFunctionConverter();
        final Matrix function = converter.generateFunctionMatrix(2, f);
        System.out.println(function);
        final Register result = Register.matrixToRegister(function.product(initial));
        System.out.println(result);
    }
    @Test
    void testEvaluatingWholeFunction()
    {
        int m = 5;
        int a = 2;
        final var calculator = new RemainderCalculator(a, m);
        final Register register = calculator.evaluateWholeFunction();
        System.out.println(register);
    }
}
