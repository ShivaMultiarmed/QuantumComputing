package mikhail.shell.quantum.computing;

import mikhail.shell.quantum.computing.lab3.MatrixToFunctionConverter;
import mikhail.shell.quantum.computing.lab3.RemainderCalculator;
import mikhail.shell.quantum.computing.lab4.FunctionAnalyzer;
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
    @Test
    void testDoychYozha() {
        Qubit x1 = Qubit.zero(), x2 = Qubit.zero(), y1 = Qubit.one();
        x1 = Qubit.matrixToQubit(Matrix.HadamardMatrix().product(x1));
        x2 = Qubit.matrixToQubit(Matrix.HadamardMatrix().product(x2));
        y1 = Qubit.matrixToQubit(Matrix.HadamardMatrix().product(y1));
        Register register = Register.matrixToRegister(x1.tensorProduct(x2).tensorProduct(y1));
        System.out.println(register);
        // константная функция
        final int[][] f = {{0}, {0}, {0}, {0}};
//        final int[][] f = {{1}, {1}, {1}, {1}};
        // сбалансированная функция
//        final int[][] f = {{1}, {0}, {1}, {0}};
//        final int[][] f = {{1}, {1}, {0}, {0}};
        // не констаная и не сбалансированная функция
//        final int[][] f = {{1}, {0}, {0}, {0}};
//        final int[][] f = {{1}, {1}, {1}, {0}};
        var converter = new MatrixToFunctionConverter();
        final Matrix function = converter.generateFunctionMatrix(2, f);
        System.out.println(function);
        final Matrix rotation = Matrix.HadamardMatrix().tensorProduct(Matrix.HadamardMatrix()).tensorProduct(Matrix.identityMatrix(2));
        // TODO: разобраться, как правильно
        register = Register.matrixToRegister(function.product(register));
        System.out.println(register);
        register = Register.matrixToRegister(rotation.product(register));
        System.out.println(register);
        final FunctionAnalyzer analyzer = new FunctionAnalyzer();
        Boolean b = analyzer.analyzeIfConstant(2, register);
        if (b == null) {
            System.out.println("Функция не константная и не сбалансированная");
        } else {
            if (b) {
                System.out.println("Функция константная");
            } else {
                System.out.println("Функция cбалансированная");
            }
        }
    }
}
