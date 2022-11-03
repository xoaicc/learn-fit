package SE1Tutorial.Tut06.ArraysTest;

import SE1Tutorial.Tut06.ArraysTest.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IsAscSorted {
    @Test
    public void testEmptyArray(){
        int[] testCase = {};
        boolean expected = true;
        boolean actual = Arrays.isAscSorted(testCase);
        assertEquals(expected, actual);
    }

    @Test
    public void testNormalArray(){
        int[] testCase = {1, 2, 3};
        boolean expected = true;
        boolean actual = Arrays.isAscSorted(testCase);
        assertEquals(expected, actual);
    }
}
