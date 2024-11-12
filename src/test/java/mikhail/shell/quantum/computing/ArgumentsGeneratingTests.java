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
        converter = new MatrixToFunctionConverter();
        double[][] result = converter.generateResultMatrixAsArray(r);
        Assertions.assertNotNull(result);
    }

    @Test
    void t()
    {
        final int[] r1 = {1,1,0,1};//, r2 = {0,1,0,1};
        var converter = new MatrixToFunctionConverter();
        final Matrix f1 = converter.generateFunctionMatrix(r1);
        //final Matrix f2 = converter.generateFunctionMatrix(r2);
        //final Matrix f = f1.tensorProduct(f2);
        Assertions.assertNotNull(f1);
        //Assertions.assertNotNull(f2);
        //Assertions.assertNotNull(f);
    }
}
