package a3;

import javax.swing.*;
import java.net.Inet4Address;
import java.util.*;

public class CollectionsAndMaps {

    /**
     * 10 Pkt
     * Löscht alle doppelten Elemente einer Liste von rechts nach links. Die Methode
     * arbeitet destruktiv auf der Eingabeliste.
     * <p>
     * Beim Löschen sollte die Liste nur genau einmal durchlaufen werden und das Prüfen auf Duplikate
     * sollte sehr effizient sein. (+3 Pkt)
     * <p>
     * Bsp.: Aus [1, 2, 5, 4, 1, 5, 1] wird [2, 4, 5, 1] UND NICHT [1, 2, 5, 4]
     *
     * @param li die Liste, aus der die Elemente gelöscht werden sollen.
     */
    public static void removeDupsFromRightToLeft(List<Integer> li) {
        Set <Integer> res = new HashSet<>();
        for(int i = li.size()-1; i >= 0; i--){
            if(!res.contains(li.get(i))) {
                res.add(li.get(i));
            }else{
                li.remove(i);
            }
        }
    }

    /**
     * 13 Pkt
     * Führt zwei Maps, deren Werte Mengen von ganzen Zahlen sind, zusammen.
     * Die Methode darf weder die erste noch die zweite Map verändern, auch nicht die
     * enthaltenen Mengen!
     * <p>
     * Das Verwenden der Methode merge der Klasse Map ist nicht erlaubt und gibt 0 Pkt!
     * <p>
     * Bsp.: Mit first {1=[11], 4=[99], 2=[1849, 122]}
     * und second {1=[233, 44], 4=[1111, 777], 3=[-7, -9]}
     * ist das Ergebnis {1=[233, 11, 44], 2=[1849, 122], 3=[-7, -9], 4=[99, 1111, 777]}
     *
     * @param first  die erste Map
     * @param second die zweite Map
     * @return eine Map mit allen Key-Value Paaren aus der ersten und der zweiten Map. Bei gemeinsamen Keys, werden die Werte
     * vereinigt.
     */
    public static Map<Integer, Set<Integer>> merge(Map<Integer, Set<Integer>> first,
                                                   Map<Integer, Set<Integer>> second) {
        Map<Integer, Set<Integer>> res = new HashMap<>(first);
        for(Integer in : second.keySet()){
            if(res.containsKey(in)){
                Set<Integer> inner = new HashSet<>(res.get(in));
                inner.addAll(second.get(in));
                res.put(in, inner);
            }else {
                res.put(in, second.get(in));
            }
        }
        return res;
    }


    /**
     * 9Pkt
     * <p>
     * Wandelt eine Map in eine Liste von zwei Listen um. In der ersten Liste sind alle Keys, in der zweiten
     * Liste alle Werte enthalten. Die Zuordnung von Key und Value ergibt sich aus der gleichen Position in
     * der jeweiligen Liste. Das Verwenden der Methoden keySet und values für Maps ist nicht erlaubt!
     * <p>
     * Bsp.: aus {2=122, 1=11, 4=99, 3=1849} wird [[2, 1, 4, 3], [122, 11, 99, 1849]]
     * aus {} wird []
     *
     * @param mii die Map, die umzuwandeln ist.
     * @return die Liste mit zwei Integer-Listen.
     */
    public static List<List<Integer>> inListOfLists(Map<Integer, Integer> mii) {
        if(mii.isEmpty()) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>(2);
        List<Integer> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : mii.entrySet()){
            keys.add(entry.getKey());
            values.add(entry.getValue());
        }
        res.add(keys);
        res.add(values);

        return res;
    }

    /**
     * 7Pkt
     * <p>
     * Wandelt eine Liste von zwei Listen in eine Map um. Die Elemente der ersten enthaltenen Liste sind
     * die Schlüssel, die der zweiten die Werte. Die Zuordnung ergibt sich aus der Position der Elemente.
     * Sie dürfen voraussetzen, dass beide Teillisten immer gleich groß sind.
     * <p>
     * Bsp.: Aus [[4, 1, 2, 3], [99, 11, 122, 1849]] wird {1=11, 2=122, 3=1849, 4=99}
     *
     * @param lii die Liste, die eine Liste für Schlüssel und eine für Werte enthält.
     * @return eine Map, deren Schlüssel aus der ersten Teilliste und deren Werte aus der zweiten Teilliste
     * stammen.
     */
    public static Map<Integer, Integer> inMap(List<List<Integer>> lii){
        Map<Integer, Integer> res = new HashMap<>();
        if(lii.isEmpty()) return res;
        if(lii.get(0).size() != lii.get(1).size()) throw new IllegalArgumentException();
        for(int i = 0; i < lii.get(0).size(); i++){
            res.put(lii.get(0).get(i), lii.get(1).get(i));
        }
        return res;
    }


    /**
     * 12Pkt
     * <p>
     * Die Methode führt in einer Liste von Listen von Integerwerten die Listen zusammen, die im ersten
     * Element übereinstimmen. Dann wird das zweite Element an die entsprechende Liste angehängt. Am Ende
     * unterscheiden sich alle enthaltenen Listen im ersten Element.
     * <p>
     * Die Methode darf die Eingabeliste nicht verändern!
     * <p>
     * Bsp.: für die Liste [[0, 18], [3, 8], [3, 24], [2, 4], [1, 12], [1, 36], [0, 2], [0, -12]]
     * ist das Ergebnis: [[0, 18, 2, -12], [3, 8, 24], [2, 4], [1, 12, 36]]
     * <p>
     * z.B. werden hier die erste und die beiden letzten Listen zusammengeführt, da deren erstes Element 0
     * ist usw.
     *
     * @param lli Die Liste von Listen
     * @return eine Liste von Listen, die sich alle im ersten Element unterscheiden.
     */
    public static List<List<Integer>> contract(List<List<Integer>> lli) {
        Map<Integer,List<Integer>> map = new LinkedHashMap<>();

        for(List<Integer> inner : lli){
            //if(inner == null || inner.size() < 2) continue;
            int key = inner.get(0);
            List<Integer> innerList = map.getOrDefault(key, new ArrayList<>());
            innerList.addAll(inner.subList(1, inner.size()));
            map.put(key, innerList);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            List<Integer> newList = new ArrayList<>();
            newList.add(entry.getKey());
            newList.addAll(entry.getValue());
            res.add(newList);
        }

        return res;
    }
}
