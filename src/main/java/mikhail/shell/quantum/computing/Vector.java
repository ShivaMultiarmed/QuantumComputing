package mikhail.shell.quantum.computing;

import static mikhail.shell.quantum.computing.MatrixOperations.vectorToMatrix;

public class Vector extends Matrix {

    public Vector(double K, double[] V) {
        super(K, vectorToMatrix(V));
    }

}
