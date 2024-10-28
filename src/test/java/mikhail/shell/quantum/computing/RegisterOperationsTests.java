package mikhail.shell.quantum.computing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegisterOperationsTests {
    @Test
    void testObservingRegister()
    {
        Register register = new Register(1/Math.sqrt(2), new double[]{ 0.0, 0.0, 1.0, 1.0});
        Observer observer = new Observer();
        observer.observe(register);
        System.out.println(register);
    }
    @Test
    void testObservingQubitInRegister()
    {
        Register register = new Register(1/Math.sqrt(3), new double[]{ 1.0, 1.0, 0, 1.0 });
        Observer observer = new Observer();
        observer.observeQubitInRegister(register, 1);
        // observer.observeQubitInRegister(register, 0);
        System.out.println(register);
    }
    @Test
    void testTransformingRegisterFromString()
    {
        String states = "0.577(-|01>-|10>+|11>)";
        Register real = Register.registerByString(states);
        Register expected = new Register(0.577, new double[]{0,-1,-1,1});
        Assertions.assertEquals(expected, real);
    }
}
