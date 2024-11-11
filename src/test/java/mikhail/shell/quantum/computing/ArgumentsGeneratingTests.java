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
    void testAddingArgument()
    {
        int[] r = {0, 0, 0, 1};
        converter = new MatrixToFunctionConverter(r);
        double[][] result = converter.generateResultMatrix();
        Assertions.assertNotNull(result);
    }
}
