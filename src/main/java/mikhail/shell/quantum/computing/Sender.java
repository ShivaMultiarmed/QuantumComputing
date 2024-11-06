package mikhail.shell.quantum.computing;

import java.util.Collection;
import java.util.LinkedList;

import static mikhail.shell.quantum.computing.MathUtils.randomFraction;

public class Sender {
    private final LinkedList<Qubit> key = new LinkedList<>();
    private final LinkedList<Boolean> observerTypes = new LinkedList<>();
    private Qubit generateQubit(boolean isBasic)
    {
        double p = randomFraction();
        Qubit q;
        if (p < 0.5)
            q = Qubit.zero();
        else
            q = Qubit.one();
        if (!isBasic)
            q = Qubit.matrixToQubit(Matrix.hadamardMatrix().product(q));
        return q;
    }
    private boolean generateBasis()
    {
        return randomFraction() < 0.5; // true - |0>, |1>; false - |0>', |1>'
    }
    public boolean sendQubit(Receiver receiver, Qubit qubit)
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
            boolean isBasic;
            Qubit q;
            do {
                isBasic = generateBasis();
                q = generateQubit(isBasic);
            } while (isBasic != sendQubit(receiver, q));
            receiver.getApproval();
            key.add(q);
            observerTypes.add(isBasic);
        }
    }
}
