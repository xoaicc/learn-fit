package SE1Tutorial.Tut06.ArraysTest;

import SE1Tutorial.Tut06.ArraysTest.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MedianTest {
    @Test
    public void testEmptyArray(){
        double[] testCase = {};
        double expected = 0;
        double actual = Arrays.median(testCase);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testNormalArray(){
        double[] testCase = {1.1, 5.5, 3.3};
        double expected = 3.3;
        double actual = Arrays.median(testCase);
        assertEquals(expected, actual, 0);
    }
}
