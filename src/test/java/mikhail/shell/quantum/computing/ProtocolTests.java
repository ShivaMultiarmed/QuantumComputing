package mikhail.shell.quantum.computing;

import mikhail.shell.quantum.computing.lab2.Receiver;
import mikhail.shell.quantum.computing.lab2.Sender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProtocolTests {
    private Sender sender;
    private Receiver receiver;
    @BeforeEach
    void init()
    {
        sender = new Sender();
        receiver = new Receiver();
    }
    @Test
    void testSendingAndReceiving()
    {
        sender.generateAndSendKey(receiver, 10);
        for (Qubit q : sender.key)
            System.out.print(q + " ");
        System.out.println();
        for (Qubit q : receiver.key)
            System.out.print(q + " ");
        Assertions.assertIterableEquals(sender.key, receiver.key);
    }
}
