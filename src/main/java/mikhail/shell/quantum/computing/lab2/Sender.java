package mikhail.shell.quantum.computing.lab2;

import mikhail.shell.quantum.computing.Matrix;
import mikhail.shell.quantum.computing.Qubit;

import java.util.LinkedList;

import static mikhail.shell.quantum.computing.MathUtils.randomFraction;

public class Sender {
    public final LinkedList<Qubit> key = new LinkedList<>();
    private final LinkedList<Integer> observerTypes = new LinkedList<>();
    private Qubit generateQubit(int basis)
    {
        double p = randomFraction();
        Qubit q;
        if (p < 0.5)
            q = Qubit.zero();
        else
            q = Qubit.one();
        if (basis == 1)
            q = Qubit.matrixToQubit(Matrix.hadamardMatrix().product(q));
        System.out.println("Сгенерирован кубит " + q);
        return q;
    }
    private int generateBasis()
    {
        // 0 для базиса |0>, |1>;
        // 1 для базиса |0>', |1>'
        boolean isBasic = randomFraction() < 0.5;
        final int basis = isBasic ? 0 : 1;
        System.out.println("Сгенерирован " + (isBasic ? "нормальный" : "повёрнутый") + " базис");
        return basis;
    }
    public int sendQubit(Receiver receiver, Qubit qubit)
    {
        System.out.println("Отправляю кубит " + qubit);
        return receiver.receive(qubit);
    }
    public void generateAndSendKey(Receiver receiver, int length)
    {
        if (!key.isEmpty())
            key.clear();
        if (!observerTypes.isEmpty())
            observerTypes.clear();
        for (int i = 0; i < length; i++)
        {
            int basis, receiverBasis;
            Qubit q;
            do {
                basis = generateBasis();
                q = generateQubit(basis);
                receiverBasis = sendQubit(receiver, q);
                if (basis != receiverBasis)
                    System.out.println("ПОВТОР");
            } while (basis != receiverBasis);
            receiver.getApproval();
            key.add(q);
            observerTypes.add(basis);
        }
    }
}
