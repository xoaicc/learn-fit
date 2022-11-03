package SE1Tutorial.Tut06.ArraysTest;

import SE1Tutorial.Tut06.ArraysTest.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CompareTest {
    @Test
    public void testEqualsCase(){
        double[] testCase1 = {};
        double[] testCase2 = {};
        int expected = 0;
        int actual = Arrays.compare(testCase1, testCase2);
        assertEquals(expected, actual);
    }

    @Test
    public void TestDisjointCase(){
        double[] testCase1 = {1.1, 2.2};
        double[] testCase2 = {3.3};
        int expected = -1;
        int actual = Arrays.compare(testCase1, testCase2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubSetCase(){
        double[] testCase1 = {1.1};
        double[] testCase2 = {1.1, 2.2};
        int expected = -1;
        int actual = Arrays.compare(testCase1, testCase2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSuperSetCase(){
        double[] testCase1 = {1.1, 2.2};
        double[] testCase2 = {1.1};
        int expected = -1;
        int actual = Arrays.compare(testCase1, testCase2);
        assertEquals(expected, actual);
    }

    @Test
    public void testIntersectsCase(){
        double[] testCase1 = {1.1, 2.2};
        double[] testCase2 = {1.3, 1.4};
        int expected = 2;
        int actual = Arrays.compare(testCase1, testCase2);
        assertEquals(expected, actual);
    }
}
