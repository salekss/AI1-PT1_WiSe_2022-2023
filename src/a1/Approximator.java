package a1;

public class Approximator {

    /**
     * Gesamt: 16Pkt
     */



    /**
     * 1Pkt
     * Prüft die gültigen Wertebereiche für x und n
     *
     * @param x der Wert, für den der Logarithmus approximiert wird
     * @param n Anzahl der Summanden
     */
    public static void checkArgs(double x, int n) {
        if(x<=0 ||n<0)throw new IllegalArgumentException();
    }

    /**
     * 3Pkt
     * Berechnet die Formel in der Näherungssumme
     *
     * @param x der Wert, für den der Logarithmus approximiert wird
     * @param n Anzahl der Summanden
     * @return Wert des n'ten Summanden der Summe
     */
    public static double formula(double x, int n){
        return 2*(Math.pow(x-1,2*n+1)/((2*n+1)*Math.pow(x+1,2*n+1)));
    }

    /**
     * 4Pkt
     * Approximiert den Logarithmus iterativ.
     *
     * @param x der Wert, für den der Logarithmus approximiert wird
     * @param n Anzahl der Summanden
     * @return Näherungswert für den Logarithmus
     */
    public static double approxIter(double x, int n){
        checkArgs(x,n);
        double res = 0;
        for(int i = 0; i <= n; i++){
            res += formula(x,i);
        }
        return res;
    }

    /**
     * 4Pkt
     * Approximiert den Logarithmus rekursiv.
     *
     * @param x der Wert, für den der Logarithmus approximiert wird
     * @param n Anzahl der Summanden
     * @return Näherungswert für den Logarithmus
     */
    public static double approxRec(double x, int n){
        checkArgs(x,n);
        double res = 0;
        if(n==0){
            return formula(x,0);
        }else{
            return formula(x,n) + approxRec(x, n-1);
        }
    }

    /**
     * 4Pkt
     * Approximiert den Logarithmus endrekursiv.
     *
     * @param x der Wert, für den der Logarithmus approximiert wird
     * @param n Anzahl der Summanden
     * @return Näherungswert für den Logarithmus
     */
    public static double approxRecTail(double x, int n){
        checkArgs(x,n);
        return approxRecTail(x,n,0); //
    }

    private static double approxRecTail(double x, int n, double acc) {
        if(n<0){
            return acc;
        }else{
            return approxRecTail(x,n-1,acc + formula(x,n));
        }
    }

}


