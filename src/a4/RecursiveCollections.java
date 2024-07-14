package a4;

import java.util.*;

public class RecursiveCollections {


    /**
     * 11Pkt
     *
     * Traversiert eine beliebig geschachtelte Liste und sammelt alle Strings in einer Map ein.
     * Die Schlüssel der Map sind die Stringlängen, die Werte die Mengen der Strings gleicher Länge.
     * Die Liste enthält neben Strings auch andere Objekte.
     *
     * Bsp.: für die Liste:
     * [3, eight, 4, six, [[[17, four, 11, six, 10.5, three], two, 1.7, ten], 9.7, twelve, 5, twelve],
     *  [3, 9, eight, 7.13, [11, eight]], three, 8, nine]
     *
     * berechnet die Methode die Map:
     * {3=[six, ten, two], 4=[nine, four], 5=[three, eight], 6=[twelve]}
     *
     * @param recursiveList ein beliebig geschachtelte Liste
     * @return die Map mit den Längen und den Mengen der Strings gleicher Länge.
     */
    public static Map<Integer, Set<String>> collectStringsByLength(List<?> recursiveList){
       return null; // TODO
    }

    /**
     * 11Pkt
     * Berechnet für eine beliebig geschachtelte Liste, die Integer und andere Objekte enthalten kann, eine Liste,
     * in der die ganzzahligen Teiler von divisor und deren Tiefe in 2-elementigen Listen enthalten sind. Das
     * erste Element der 2-elementigen Liste ist die Tiefe des Teiler in der objectList, das zweite der Teiler
     * selbst.
     *
     * Bsp.:
     * für die Liste [ hi, 7.0, 18, [[[7, hallo, 8, 13, 24], du, 7, 4], da, 4.0, 12],
     *                 [noe, 1, 80.0, 36, [yes]], 2, -12]
     *
     * berechnet die Methode mit divisor 2:
     * [[0, 18], [3, 8], [3, 24], [2, 4], [1, 12], [1, 36], [0, 2], [0, -12]]
     *
     * @param objectList die beliebig geschachtelte Liste
     * @param divisor der Teiler
     * @return eine Liste mit 2-elementigen Listen.
     */
    public static List<List<Integer>> dividerWithDepth(List<?> objectList,int divisor){
        return null;
    }

}
