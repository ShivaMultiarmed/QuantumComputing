package mikhail.shell.quantum.computing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QubitOperationsTests {
    @Test
    void qubitToRegister1()
    {
        final Qubit qubit1 = new Qubit(1, 1, 0);
        final Qubit qubit2 = new Qubit(1, 1, 0);
        final Matrix expected = new Vector(1, new double[] {1, 0, 0, 0});
        final Matrix real = qubit1.tensorProduct(qubit2);
        assertEquals(expected, real);
    }
    @Test
    void qubitToRegister2()
    {
        final Qubit qubit1 = new Qubit(1/ sqrt(2), 1, 1);
        final Qubit qubit2 = new Qubit(1, 1, 0);
        final Matrix expected = new Vector(1/ sqrt(2), new double[] {1, 0, 1, 0});
        final Matrix real = qubit1.tensorProduct(qubit2);
        assertEquals(expected, real);
    }
    @Test
    void testHadamarTransform()
    {
        final Qubit q = new Qubit(1, 1, 0);
        final Matrix h = new Matrix(
                1/ sqrt(2),
                new double[][] {
                        {1, 1},
                        {1, -1}
                });
        final Qubit expected = new Qubit(1/sqrt(2), 1, 1);
        final Matrix real = h.product(q);
        Assertions.assertEquals(expected, real);
    }
}
