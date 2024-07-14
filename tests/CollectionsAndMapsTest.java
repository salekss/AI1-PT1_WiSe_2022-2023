import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static a3.CollectionsAndMaps.*;
import static org.junit.jupiter.api.Assertions.*;


public class CollectionsAndMapsTest {

    private Map<Integer, Set<Integer>> misi1, misi2, misi1Copy, misi1Disjoint, misi2Copy,
            merged, mergedDisjoint, mergedDisjointKopie, emptySetMap;

    private final String msgChangedFirstArgument = "Methode hat das erste Argument verändert";
    private final String msgChangedSecondArgument = "Methode hat das zweite Argument verändert";

    private List<Integer> li, withoutDups, withoutDupsCopy, emptyLi;
    private Map<Integer, Integer> mii, emptyMap;
    private List<List<Integer>> lli, emptyLli;

    private List<List<Integer>> lli2, lli2Copy, lliC, lliCCopy, emptyLiiCopy;

    @BeforeEach
    public void init() {
        initForMapMerge();
        initListOfListsMap();
        initListsForRemove();
        initListsForContract();
    }

    private void initForMapMerge() {
        misi1 = Map.of(1, new HashSet<>(Set.of(11)),
                2, new HashSet<>(Set.of(122, 1849)),
                4, new HashSet<>(Set.of(99)));
        misi1Copy = Map.of(1, new HashSet<>(Set.of(11)),
                2, new HashSet<>(Set.of(122, 1849)),
                4, new HashSet<>(Set.of(99)));
        misi1Disjoint = Map.of(3, new HashSet<>(Set.of(233, 44)),
                5, new HashSet<>(Set.of(-7, -9)));
        misi2 = Map.of(1, new HashSet<>(Set.of(233, 44)),
                3, new HashSet<>(Set.of(-7, -9)),
                4, new HashSet<>(Set.of(1111, 777)));
        misi2Copy = Map.of(1, new HashSet<>(Set.of(233, 44)),
                3, new HashSet<>(Set.of(-7, -9)),
                4, new HashSet<>(Set.of(1111, 777)));

        merged = Map.of(1, Set.of(11, 233, 44),
                2, Set.of(122, 1849),
                3, Set.of(-7, -9),
                4, Set.of(99, 1111, 777));

        mergedDisjoint = new HashMap<>(Map.of(1, new HashSet<>(Set.of(11)),
                2, new HashSet<>(Set.of(122, 1849)),
                4, new HashSet<>(Set.of(99)),
                3, new HashSet<>(Set.of(233, 44)),
                5, new HashSet<>(Set.of(-7, -9))));

        mergedDisjointKopie = new HashMap<>(Map.of(1, new HashSet<>(Set.of(11)),
                2, new HashSet<>(Set.of(122, 1849)),
                4, new HashSet<>(Set.of(99)),
                3, new HashSet<>(Set.of(233, 44)),
                5, new HashSet<>(Set.of(-7, -9))));

        emptySetMap = new HashMap<>();

    }

    @Test
    public void testMergePos() {
        assertEquals(merged, merge(misi1, misi2));
        assertAll(
                () -> assertEquals(misi1Copy, misi1, msgChangedFirstArgument),
                () -> assertEquals(misi2Copy, misi2, msgChangedSecondArgument));
    }

    @Test
    public void testMergeBound1() {
        assertEquals(misi1Copy, merge(emptySetMap, misi1));
        assertAll(
                () -> assertEquals(new HashMap<>(), emptySetMap, msgChangedFirstArgument),
                () -> assertEquals(misi1Copy, misi1, msgChangedSecondArgument),
                () -> assertNotSame(misi1, merge(emptySetMap, misi1)));
    }

    @Test
    public void testMergeBound2() {
        assertEquals(mergedDisjoint, merge(misi1, misi1Disjoint));
        assertAll(
                () -> assertEquals(misi1Copy, misi1, msgChangedFirstArgument),
                () -> assertEquals(mergedDisjointKopie, mergedDisjoint, msgChangedSecondArgument)
        );
    }


    private void initListOfListsMap() {
        mii = Map.of(1, 11, 2, 122, 3, 1849, 4, 99);
        lli = List.of(List.of(1, 2, 3, 4), List.of(11, 122, 1849, 99));
        emptyLli = new ArrayList<>();
        emptyMap = new HashMap<>();
    }

    private boolean comparePermute(List<List<Integer>> lli1, List<List<Integer>> lli2){
        int size =  lli1.get(0).size();
        for (int i=0; i < size; i++ ) {
            Integer key = lli1.get(0).get(i);
            Integer value = lli1.get(1).get(i);
            int keyPos = lli2.get(0).indexOf(key);
            if (!lli2.get(1).get(keyPos).equals(value)) return false;
        }
        return true;
    }


    @Test
    public void testInListOfListsPos() {
        List<List<Integer>> lliCalc = inListOfLists(mii);
        assertTrue(comparePermute(lli,lliCalc));
    }

    @Test
    public void testInListOfListsBound() {
        assertEquals(emptyLli, inListOfLists(emptyMap));
    }


    @Test
    public void inMapPos() {
        assertEquals(mii, inMap(lli));
    }

    @Test
    public void inMapBound() {
        assertEquals(emptyMap, inMap(emptyLli));
    }

    private void initListsForContract(){
       lli2 = new ArrayList<>(List.of(
                new ArrayList<>(List.of(0, 18)), new ArrayList<>(List.of(3, 8)),
                List.of(3, 24), List.of(2, 4),
                new ArrayList<>(List.of(1, 12)), List.of(1, 36), List.of(0, 2), List.of(0, -12)));

       lli2Copy = new ArrayList<>(List.of(
                new ArrayList<>(List.of(0, 18)), new ArrayList<>(List.of(3, 8)),
                List.of(3, 24), List.of(2, 4),
                new ArrayList<>(List.of(1, 12)), List.of(1, 36), List.of(0, 2), List.of(0, -12)));

       lliC = List.of(List.of(0, 18, 2, -12), List.of(3, 8, 24), List.of(2, 4),
                List.of(1, 12, 36));

       lliCCopy = List.of(List.of(0, 18, 2, -12), List.of(3, 8, 24), List.of(2, 4),
                List.of(1, 12, 36));

       emptyLiiCopy = new ArrayList<>();
    }

    @Test
    public void testContractPos() {
        assertEquals(lliC, contract(lli2));
        assertEquals(lli2Copy, lli2);
    }

    @Test
    public void testContractBound() {
        assertAll(() -> {
                    assertEquals(lliCCopy, contract(lliC));
                    List<List<Integer>> lliCCalc = contract(lliC);
                    assertAll(
                            () -> assertEquals(lliCCopy, lliC),
                            () -> assertNotSame(lliCCalc, lliC));
                },
                () -> {
                    assertEquals(emptyLiiCopy, contract(emptyLli));
                    List<List<Integer>> emptyLiiCCalc = contract(emptyLli);
                    assertAll(
                            () -> assertEquals(emptyLiiCopy, emptyLli),
                            () -> assertNotSame(emptyLiiCCalc, emptyLli)
                    );
                });
    }


    private void initListsForRemove() {
        li = new ArrayList<>(List.of(2, 1, 2, 5, 5, 4, 1, 5, 1));
        withoutDups = List.of(2, 4, 5, 1);
        withoutDupsCopy = List.of(2, 4, 5, 1);
        emptyLi = new ArrayList<>();
    }

    @Test
    public void testRemoveDupsPos() {
        removeDupsFromRightToLeft(li);
        assertEquals(withoutDups, li);
    }

    @Test
    public void testRemoveDupsBound() {
        assertAll(
                () -> {
                    removeDupsFromRightToLeft(withoutDups);
                    assertEquals(withoutDupsCopy, withoutDups);
                },
                () -> assertDoesNotThrow(
                        () -> removeDupsFromRightToLeft(emptyLi))
        );
    }

}
