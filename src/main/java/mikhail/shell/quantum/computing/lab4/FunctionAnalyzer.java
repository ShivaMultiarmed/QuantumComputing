package mikhail.shell.quantum.computing.lab4;

import mikhail.shell.quantum.computing.Register;

public class FunctionAnalyzer {
    public Boolean analyzeIfConstant(int argsNumber, Register register) {
        double p = 0;
        for (int i = 0, k = 0; i < register.M.length; i++)
            if (register.M[i][0] != 0) {
                k++;
                p += Math.pow(register.K * register.M[i][0], 2);
                if (0.99 <= p && p <= 1.01 && k == argsNumber) {
                    return i + 1 == argsNumber;
                }
            }
        return null;
    }
}
