package mikhail.shell.quantum.computing;

import mikhail.shell.quantum.computing.lab3.FunctionMatrix;
import mikhail.shell.quantum.computing.lab3.FunctionOperations;
import mikhail.shell.quantum.computing.lab3.MatrixToFunctionConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArgumentsGeneratingTests {
    private MatrixToFunctionConverter converter;
    @Test
    void testGeneratingArguments()
    {
        int[][] m = FunctionOperations.generateArguments(3);
        Assertions.assertNotNull(m);
    }
    @Test
    void testGeneratingMatrixWithArgsAndResult()
    {
        int[] r = {0, 0, 0, 1};
        final Matrix real = new FunctionMatrix(r);
        Assertions.assertNotNull(real);
    }
    @Test
    void testQubitBooleanFunction()
    {
        final int[] r = {0,0,0,1};
        var converter = new MatrixToFunctionConverter();
        final Matrix f = converter.generateFunctionMatrix(r);
        final Qubit q1 = Qubit.zero(), q2 = Qubit.one(), q3 = Qubit.zero();
        final Register register = Register.matrixToRegister(q1.tensorProduct(q2).tensorProduct(q3));
        final Register resultRegister = Register.matrixToRegister(f.product(register));
        Assertions.assertNotNull(resultRegister);
    }

    @Test
    void t()
    {
        final int[] r1 = {0,1,1,0}, r2 = {0,1,0,1};
        var converter = new MatrixToFunctionConverter();
        final Matrix f1 = converter.generateFunctionMatrix(r1);
        final Matrix f2 = converter.generateFunctionMatrix(r2);
        final Matrix f = f1.product(f2);
        Assertions.assertNotNull(f1);
        Assertions.assertNotNull(f2);
        Assertions.assertNotNull(f);
    }
}
