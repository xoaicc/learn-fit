package SE1Tutorial.Tut06.ArraysTest;

import SE1Tutorial.Tut06.ArraysTest.Arrays;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FreqTest {
    @Test
    public void testEmptyCase(){
        double[] testCase = {};
        int[] expected = {};
        int[] actual = Arrays.freq(testCase);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testNormalCase(){
        double[] testCase = {1.1, 2.2, 1.1};
        int[] expected = {2, 1};
        int[] actual = Arrays.freq(testCase);
        assertArrayEquals(expected, actual);
    }
}
