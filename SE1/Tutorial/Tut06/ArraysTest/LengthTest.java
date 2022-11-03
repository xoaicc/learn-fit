package SE1Tutorial.Tut06.ArraysTest;

import SE1Tutorial.Tut06.ArraysTest.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LengthTest {
    @Test
    public void testEmptyArray(){
        char[] testCase = {};
        int expected = 0;
        int actual = Arrays.length(testCase);
        assertEquals(expected, actual);
    }

    @Test
    public void testNormalArray(){
        char[] testCase = {'a', 'b', 'c'};
        int expected = 3;
        int actual = Arrays.length(testCase);
        assertEquals(expected, actual);
    }
}
