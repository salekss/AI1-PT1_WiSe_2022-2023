package a1;

import static a1.Approximator.*;
public class ApproximatorMain {

        public static void main(String[] args) {

        double x_001 = 0.001;
        int n0 = 0, n20 =20, n100=100, n1000= 1000;
        double x15_9 = 15.9;

        System.out.printf("ln(%e)=%1.15e%n",x_001,Math.log(x_001));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n0,approxIter(x_001,n0), Math.log(x_001)-approxIter(x_001,n0));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n20,approxIter(x_001,n20), Math.log(x_001)-approxIter(x_001,n20));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n100,approxIter(x_001,n100), Math.log(x_001)-approxIter(x_001,n100));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n1000,approxIter(x_001,n1000), Math.log(x_001)-approxIter(x_001,n1000));
        System.out.println("Rec");
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n0,approxRec(x_001,n0), Math.log(x_001)-approxRec(x_001,n0));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n20,approxRec(x_001,n20), Math.log(x_001)-approxRec(x_001,n20));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n100,approxRec(x_001,n100), Math.log(x_001)-approxRec(x_001,n100));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n1000,approxRec(x_001,n1000), Math.log(x_001)-approxRec(x_001,n1000));
        System.out.println("RecTail");
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n0,approxRecTail(x_001,n0), Math.log(x_001)-approxRecTail(x_001,n0));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n20,approxRecTail(x_001,n20), Math.log(x_001)-approxRecTail(x_001,n20));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n100,approxRecTail(x_001,n100), Math.log(x_001)-approxRecTail(x_001,n100));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x_001,n1000,approxRecTail(x_001,n1000), Math.log(x_001)-approxRecTail(x_001,n1000));

        System.out.println("X2");
        System.out.printf("ln(%e)=%1.15e%n",x15_9,Math.log(x15_9));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x15_9,n0,approxIter(x15_9,n0), Math.log(x15_9)-approxIter(x15_9,n0));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x15_9,n20,approxIter(x15_9,n20), Math.log(x15_9)-approxIter(x15_9,n20));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x15_9,n100,approxIter(x15_9,n100), Math.log(x15_9)-approxIter(x15_9,n100));
        System.out.println("Rec");
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x15_9,n0,approxRec(x15_9,n0), Math.log(x15_9)-approxRec(x15_9,n0));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x15_9,n20,approxRec(x15_9,n20), Math.log(x15_9)-approxRec(x15_9,n20));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x15_9,n100,approxRec(x15_9,n100), Math.log(x15_9)-approxRec(x15_9,n100));
        System.out.println("RecTail");
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x15_9,n0,approxRecTail(x15_9,n0), Math.log(x15_9)-approxRecTail(x15_9,n0));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x15_9,n20,approxRecTail(x15_9,n20), Math.log(x15_9)-approxRecTail(x15_9,n20));
        System.out.printf("ln(%e,%d)=%1.15e (%1.15e)%n",x15_9,n100,approxRecTail(x15_9,n100), Math.log(x15_9)-approxRecTail(x15_9,n100));

        System.out.println("Formula");
        System.out.printf("formula(%e,%d)=%1.15e%n",x_001,n0,formula(x_001,n0));
        System.out.printf("formula(%e,%d)=%1.15e%n",x_001,n20,formula(x_001,n20));
        System.out.printf("formula(%e,%d)=%1.15e%n",x_001,n100,formula(x_001,n100));
        System.out.printf("formula(%e,%d)=%1.15e%n",x_001,n1000,formula(x_001,n1000));

        System.out.printf("formula(%e,%d)=%1.15e%n",x15_9,n0,formula(x15_9,n0));
        System.out.printf("formula(%e,%d)=%1.15e%n",x15_9,n20,formula(x15_9,n20));
        System.out.printf("formula(%e,%d)=%1.15e%n",x15_9,n100,formula(x15_9,n100));

    }
}
