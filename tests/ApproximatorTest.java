import org.junit.jupiter.api.Test;

import static a1.Approximator.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApproximatorTest {
    
    private final double x_001 = 0.001, x15_9 = 15.9;
    private final double xNeg1 = 0, xNeg2 = -33.17;
    private final int nNeg1 = -1, nNeg2 = -22;
    private final int n0 = 0, n20 = 20, n100 = 100, n1000 = 1000;
    
    private final double delta_001_n0 = 4.91175128298e+00;
    ; // 4.911751282978141e+00;
    private final double delta_001_n20 = 1.98189679549e+00; //1.981896795486535e+00;
    private final double delta_001_n100 = 6.95719461358e-01; //6.957194613575233e-01;
    private final double delta_001_n1000 = 3.76107260395e-03; // 3.761072603948534e-03;

    private final double delta15_9_n0 = 1.00300549976e+00; // 1.003005499758730e+00;
    private final double delta15_9_n20 = 8.15093708891e-04; // 8.150937088902133e-04;
    private final double delta15_9_n100 = 3.35287353437e-13; // 3.352873534367973e-13;
    private final double delta15_9_n100Tail = 3.36175531857e-13; // 3,361755318564974e-13;

    
    private final double f_001_n0 =    -1.996003996003996e+00;
    private final double f_001_n20 =   -4.494009431780022e-02;
    private final double f_001_n100 =  -6.656523940765111e-03;
    private final double f_001_n1000 = -1.826988489114091e-05;
    private final double delta_f_001 =  0.000000000002;
    private final double f15_9_n0 =   1.763313609467456e+00;
    private final double f15_9_n20 =  2.789512132806536e-04;
    private final double f15_9_n100 = 1.007038934581548e-13;
    private final double delta_f15_9 = 0.000000000002;


    @Test
    public void testFormula() {
        assertAll(
                () -> assertEquals(f_001_n0,formula(x_001,n0), delta_f_001),
                () -> assertEquals(f_001_n20,formula(x_001,n20), delta_f_001),
                () -> assertEquals(f_001_n100,formula(x_001,n100), delta_f_001),
                () -> assertEquals(f_001_n1000,formula(x_001,n1000),delta_f_001),
                () -> assertEquals(f15_9_n0,formula(x15_9,n0), delta_f15_9),
                () -> assertEquals(f15_9_n20,formula(x15_9,n20),delta_f15_9),
                () -> assertEquals(f15_9_n100,formula(x15_9,n100),delta_f15_9)
        );
    }

    @Test
    public void testCheckArgs() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> checkArgs(xNeg1, n20)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> checkArgs(xNeg2, n100)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> checkArgs(x_001, nNeg1)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> checkArgs(x15_9, nNeg2)),
                () -> assertDoesNotThrow(
                        () -> checkArgs(x_001, n0)),
                () -> assertDoesNotThrow(
                        () -> checkArgs(x15_9, n100))
        );
    }

    @Test
    public void testApproxIterPos() {

        assertAll(
                () -> assertEquals(Math.log(x_001),approxIter(x_001,n0), delta_001_n0),
                () -> assertEquals(Math.log(x_001),approxIter(x_001,n20), delta_001_n20),
                () -> assertEquals(Math.log(x_001),approxIter(x_001,n100), delta_001_n100),
                () -> assertEquals(Math.log(x_001),approxIter(x_001,n1000), delta_001_n1000),
                () -> assertEquals(Math.log(x15_9),approxIter(x15_9,n0), delta15_9_n0),
                () -> assertEquals(Math.log(x15_9),approxIter(x15_9,n20), delta15_9_n20),
                () -> assertEquals(Math.log(x15_9),approxIter(x15_9,n100), delta15_9_n100)
        );

    }

    @Test
    public void testApproxIterNeg() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxIter(xNeg1, n20)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxIter(xNeg2, n100)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxIter(x_001, nNeg1)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxIter(x15_9, nNeg2))
        );
    }

    @Test
    public void testApproxRecPos() {
        assertAll(
                () -> assertEquals(Math.log(x_001),approxRec(x_001,n0), delta_001_n0),
                () -> assertEquals(Math.log(x_001),approxRec(x_001,n20), delta_001_n20),
                () -> assertEquals(Math.log(x_001),approxRec(x_001,n100), delta_001_n100),
                () -> assertEquals(Math.log(x_001),approxRec(x_001,n1000), delta_001_n1000),
                () -> assertEquals(Math.log(x15_9),approxRec(x15_9,n0), delta15_9_n0),
                () -> assertEquals(Math.log(x15_9),approxRec(x15_9,n20), delta15_9_n20),
                () -> assertEquals(Math.log(x15_9),approxRec(x15_9,n100), delta15_9_n100)
        );
    }

    @Test
    public void testApproxRecNeg() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxRec(xNeg1, n20)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxRec(xNeg2, n100)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxRec(x_001, nNeg1)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxRec(x15_9, nNeg2))
        );
    }

    @Test
    public void testApproxRecTailPos() {
        assertAll(
                () -> assertEquals(Math.log(x_001),approxRecTail(x_001,n0), delta_001_n0),
                () -> assertEquals(Math.log(x_001),approxRecTail(x_001,n20), delta_001_n20),
                () -> assertEquals(Math.log(x_001),approxRecTail(x_001,n100), delta_001_n100),
                () -> assertEquals(Math.log(x_001),approxRecTail(x_001,n1000), delta_001_n1000),
                () -> assertEquals(Math.log(x15_9),approxRecTail(x15_9,n0), delta15_9_n0),
                () -> assertEquals(Math.log(x15_9),approxRecTail(x15_9,n20), delta15_9_n20),
                () -> assertEquals(Math.log(x15_9),approxRecTail(x15_9,n100), delta15_9_n100Tail)
        );
    }

    @Test
    public void testApproxRecTailNeg() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxRecTail(xNeg1, n20)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxRecTail(xNeg2, n100)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxRecTail(x_001, nNeg1)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> approxRecTail(x15_9, nNeg2))
        );
    }
}
