package mikhail.shell.quantum.computing;

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
        System.out.println();
    }
}
