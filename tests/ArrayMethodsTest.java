import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static a2.ArrayMethods.*;

public class ArrayMethodsTest {

    private final String ary2DString = "1,2,3&4,5&7,8,9,11&12,13";
    private final int[][] ary2D = {{1,2,3},{4,5},{7,8,9,11},{12,13}};
    private final int[][] ary2DEmpty = {};
    private final int[] toSeparate1 = {1,12,3,74,105,16};
    private final int[] toSeparate1Copy =  {1,12,3,74,105,16};
    private final int[] toSeparate2 = {1,12,3,74,105,16,999};
    private final int[] toSeparate2Copy = {1,12,3,74,105,16,999};
    private final int[][] separated1 = {{1,12,3},{74,105,16}};
    private final int[][] separated2 = {{1,12,3,74},{105,16,999}};

    private final int[] ary1DEmpty = {};


    @Test
    public void testSeparatePos(){
       assertAll(
               () -> {
                   assertArrayEquals(separated1, separate(toSeparate1));
                   assertArrayEquals(toSeparate1Copy,toSeparate1);
               },
               () -> {
                   assertArrayEquals(separated2, separate(toSeparate2));
                   assertArrayEquals(toSeparate2Copy,toSeparate2);
               }
       );
    }

    @Test
    public void testSeparateBound(){
        assertArrayEquals(ary2DEmpty, separate(ary1DEmpty));

    }

    @Test
    public void testFromStringPos(){
        assertArrayEquals(ary2D, fromString(ary2DString));
    }
    @Test
    public void testFromStringBound(){
        assertArrayEquals(ary2DEmpty, fromString(""));
    }
}
