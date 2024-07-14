import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static a4.RecursiveCollections.*;

public class RecursiveCollectionsTest {

    private List<?> emptyList;
    List<List<Integer>> emptyListOfLists;
    private List<?> nestedListForDivider;
    private final int divisorNotContained = 5;
    List<List<Integer>> divider2List, divider3List, divider4List, divider7List, divider13List, divider18List;

    @BeforeEach
    public void init(){
        emptyList = new ArrayList<>();
        emptyListOfLists = new ArrayList<>();
        nestedListForDivider = List.of("hi",7.0, 18, List.of(List.of(List.of(7,"hallo",8,13,24),"du", 7, 4), "da", 4.0, 12  ),
                List.of("noe", 1, 80.0, 36, List.of("yes")), 2, -12);
       divider2List = List.of(
                List.of(0,18), List.of(3,8),List.of(3,24), List.of(2,4),
                List.of(1,12), List.of(1,36), List.of(0,2), List.of(0, -12));
        divider3List = List.of(
                List.of(0,18),List.of(3,24), List.of(1,12), List.of(1,36),
                List.of(0, -12));
        divider4List = List.of(
                List.of(3,8),List.of(3,24), List.of(2,4), List.of(1,12),
                List.of(1,36),List.of(0, -12));
        divider7List = List.of(
                List.of(3,7),List.of(2,7));
        divider13List = List.of(
                List.of(3,13));
        divider18List = List.of(
                List.of(0,18), List.of(1,36));
    }

    @Test
    public void testCollectStringsPos(){
        List<?> nestedStringList = List.of(3,"eight", 4, "six",
                List.of(List.of(List.of(17,"four",11,"six",10.5,"three"),"two", 1.7, "ten"), 9.7, "twelve", 5, "twelve"  ),
                List.of(3, 9, "eight", 7.13, List.of(11,"eight")), "three", 8, "nine");
        Map<Integer, Set<String>> mils = new HashMap<>(Map.of(3, Set.of("six", "ten", "two"),4,
                Set.of("nine", "four"),  5, Set.of("three", "eight"),6, Set.of("twelve")));

        assertEquals(mils,collectStringsByLength(nestedStringList));
    }

    @Test
    public void testCollectStringsBound(){
        List<?> listWithoutStrings = List.of(8, 4, 6,
                List.of(List.of(List.of(4,11,6,10.5,3),2, 1.7, 10), 12, 5, 12  ),
                List.of(3, 9, 8, 7.13, List.of(8)), 3, 9);
        Map<Integer,Set<String>> emptyMap = new HashMap<>();

        assertAll(
                () -> assertEquals(emptyMap,collectStringsByLength(emptyList)),
                () -> assertEquals(emptyMap,collectStringsByLength(listWithoutStrings)));
    }

    @Test
    public void testDividerPos(){
        System.out.println(nestedListForDivider);

        assertAll(
                () -> assertEquals(divider2List, dividerWithDepth(nestedListForDivider,2)),
                () -> assertEquals(divider3List, dividerWithDepth(nestedListForDivider,3)),
                () -> assertEquals(divider4List, dividerWithDepth(nestedListForDivider,4)),
                () -> assertEquals(divider7List, dividerWithDepth(nestedListForDivider,7)),
                () -> assertEquals(divider13List, dividerWithDepth(nestedListForDivider,13)),
                () -> assertEquals(divider18List, dividerWithDepth(nestedListForDivider,18))
        );

    }

    @Test
    public void testDividerBound(){

       assertAll(
                () -> assertEquals(emptyListOfLists, dividerWithDepth(emptyList,2)),
                () -> assertEquals(emptyListOfLists,dividerWithDepth(nestedListForDivider,divisorNotContained))
        );
    }
}
