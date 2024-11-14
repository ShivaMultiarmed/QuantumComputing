package mikhail.shell.quantum.computing;

import mikhail.shell.quantum.computing.lab3.RemainderCalculator;
import mikhail.shell.quantum.computing.lab3.SimpleFunctionMatrix;
import mikhail.shell.quantum.computing.lab3.FunctionOperations;
import mikhail.shell.quantum.computing.lab3.MatrixToFunctionConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArgumentsGeneratingTests {
    private MatrixToFunctionConverter converter;
    @Test
    void testGeneratingArguments()
    {
//        int[][] m = FunctionOperations.generateArguments(3);
//        Assertions.assertNotNull(m);
    }
    @Test
    void testGeneratingMatrixWithArgsAndResult()
    {
//        int[][] r = {{1}, {1}, {0}, {1}};
//        final Matrix real = new SimpleFunctionMatrix(r);
//        Assertions.assertNotNull(real);
    }
    @Test
    void testQubitBooleanFunction()
    {
//        final int[][] r = {{1},{1},{0},{1}};
//        var converter = new MatrixToFunctionConverter();
//        final Matrix f = converter.generateFunctionMatrix(r);
//        final Qubit q1 = Qubit.zero(), q2 = Qubit.one(), q3 = Qubit.zero();
//        final Register register = Register.matrixToRegister(q1.tensorProduct(q2).tensorProduct(q3));
//        System.out.println(register);
//        final Register resultRegister = Register.matrixToRegister(f.product(register));
//        Assertions.assertNotNull(resultRegister);
//        System.out.println(resultRegister);
    }

    @Test
    void testMultipleFunction()
    {
        final int[][] r = {{0,0},{1,1},{1,0},{0,1}};
        var converter = new MatrixToFunctionConverter();
        final Matrix f = converter.generateFunctionMatrix(r);
        final Qubit q1 = Qubit.zero(), q2 = Qubit.one(), q3 = Qubit.zero(), q4 = Qubit.zero();
        Assertions.assertNotNull(f);
    }

    @Test
    void evaluateRemainder()
    {
        int x = 2;
        int m = 7;
        int a = 3;
        final RemainderCalculator calculator = new RemainderCalculator(a, m);
        int expected = 6;
        int real = calculator.evaluateRemainder(x);
        Assertions.assertEquals(expected, real);
    }
}
