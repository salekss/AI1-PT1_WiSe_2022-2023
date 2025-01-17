package a2;

import java.util.Arrays;

public class ArrayMethods {

    /**
     * 9 Pkt
     * Trennt ein int[]-Array in der Mitte auf und sammelt die beiden Hälften in einem int[][]-Array.
     * Die erste Hälfte sollte ggf. länger sein als die zweite.
     * Wenn das Eingabe-Array leer ist, dann ist das Ergebnis ein leeres 2D-Array.
     * <p>
     * Bsp.: für {1,12,3,74,105,16} ist das Ergebnis {{1,12,3},{74,105,16}}
     * für {1,12,3,74,105,16,999} ist das Ergebnis {{1,12,3,74},{105,16,999}}. Das erste Array ist das längere!
     *
     * @param ary das aufzutrennende Array
     * @return ein 2D Array, dessen erstes Element die erste Hälfte und dessen zweites Element
     * die zweite Hälfte des Eingabe-Arrays enthält. Dabei soll die erste Hälfte ggf. die längere sein.
     */
    public static int[][] separate(int[] ary) {
        if(ary.length == 0) return new int[0][];
        int[][] res = new int[2][];
        if(ary.length%2 == 0){
            res[0]= Arrays.copyOfRange(ary,0,ary.length/2);
            res[1]= Arrays.copyOfRange(ary,ary.length/2,ary.length);
        }else{
            res[0]= Arrays.copyOfRange(ary,0,ary.length/2+1);
            res[1]= Arrays.copyOfRange(ary,ary.length/2+1,ary.length);
        }
        return res;
    }
    /**
     * 10 Pkt
     * <p>
     * Die Methode wandelt eine Zeichenkette in ein unregelmäßiges int[][] Array um.
     * Die Zeilen des Zielarrays sind durch das Zeichen '&' getrennt. Die Elemente der
     * Zeilen durch das Zeichen ','. Zwischen den Trennzeichen steht immer mindestens ein
     * int-Wert. Die leere Zeichenkette liefert ein leeres int[][] Array.
     * <p>
     * Sie dürfen mit der Methode split der Klasse String arbeiten.
     * <p>
     * Bsp.: "1,2,3&4,5&7,8,9,11&12,13" ergibt [[1, 2, 3], [4, 5], [7, 8, 9, 11], [12, 13]]
     * "" ergibt []
     *
     * @param ary2DString eine Zeichenkette, die ein unregelmäßiges int[][] Array kodiert.
     * @return ein int[][] Array mit den Werten der Zeichenkette.
     */
    public static int[][] fromString(String ary2DString) {
        if(ary2DString.isEmpty()) return new int[0][];

        String[] sub = ary2DString.split("&");
        int[][] res = new int[sub.length][];

        for(int i = 0; i < sub.length; i++){
            String[] inSub = sub[i].split(",");
            int[] intSub = new int[inSub.length];

            for(int j = 0; j < inSub.length; j++){
                intSub[j] = Integer.parseInt(inSub[j].trim());
            }
            res[i] = intSub;
        }
        return res;
    }
}
