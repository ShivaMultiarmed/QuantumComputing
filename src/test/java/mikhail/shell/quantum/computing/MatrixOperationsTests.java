package mikhail.shell.quantum.computing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static mikhail.shell.quantum.computing.MatrixOperations.product;
import static mikhail.shell.quantum.computing.MatrixOperations.tensorProduct;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixOperationsTests {
    @Test
    void testMatrixProduct1()
    {
        double[][] matrixA = {
                {1, 2},
                {3, 4}
        };

        double[][] matrixB = {
                {5, 6},
                {7, 8}
        };

        double[][] expected = {
                {19, 22},
                {43, 50}
        };
        double[][] real = product(matrixA, matrixB);
        assertArrayEquals(expected, real);
    }
    @Test
    void testMatrixProduct2()
    {
        double[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] matrixB = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        double[][] expected = {
                {58, 64},
                {139, 154}
        };
        double [][] real = product(matrixA, matrixB);
        assertArrayEquals(expected, real);
    }
    @Test
    void testTensorProduct1()
    {
        double[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] matrixB = {
                {7, 8},
                {9, 10},
                {11, 12}
        };
        double[][] result = tensorProduct(matrixA, matrixB);
        System.out.println(result);
    }
}
