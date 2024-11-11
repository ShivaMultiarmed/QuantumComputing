package mikhail.shell.quantum.computing;

import java.util.LinkedList;
import java.util.List;

import static mikhail.shell.quantum.computing.MathUtils.randomFraction;

public class Receiver {
    private Qubit currentQubit;
    private boolean isCurrentBasisBasic;
    public final LinkedList<Qubit> key = new LinkedList<>();
    private final LinkedList<Boolean> observerTypes = new LinkedList<>();
    private final Observer observer = new Observer();
    public int receive(Qubit q)
    {
        final double p = randomFraction();
        final boolean isBasic = p < 0.5;
        if (isBasic)
            observer.observe(q);
        else
            observer.observeH(q);
        currentQubit = q;
        System.out.println("Принял кубит " + q);
        isCurrentBasisBasic = isBasic;
        System.out.println("Померил в " + (isBasic ? "нормальном" : "повернутом") + " базисе");
        return isBasic ? 0 : 1;
    }
    public void getApproval()
    {
        key.add(currentQubit);
        observerTypes.add(isCurrentBasisBasic);
        System.out.println("ОК");
    }
}
