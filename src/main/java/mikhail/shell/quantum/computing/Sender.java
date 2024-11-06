package mikhail.shell.quantum.computing;

import java.util.Collection;
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
        return q;
    }
    private int generateBasis()
    {
        // 0 для базиса |0>, |1>;
        // 1 для базиса |0>', |1>'

        return randomFraction() < 0.5 ? 0 : 1;
    }
    public int sendQubit(Receiver receiver, Qubit qubit)
    {
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
            int basis;
            Qubit q;
            do {
                basis = generateBasis();
                q = generateQubit(basis);
            } while (basis != sendQubit(receiver, q));
            receiver.getApproval();
            key.add(q);
            observerTypes.add(basis);
        }
    }
}
