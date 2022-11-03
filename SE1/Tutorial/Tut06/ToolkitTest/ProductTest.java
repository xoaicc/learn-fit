package SE1Tutorial.Tut06.ToolkitTest;

import SE1Tutorial.Tut06.ToolkitTest.Toolkit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void testNullCase(){
        int[] testCase = null;
        long expected = -1;
        long actual = Toolkit.product(testCase);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyCase(){
        int[] testCase = new int [0];
        long expected = -1;
        long actual = Toolkit.product(testCase);
        assertEquals(expected, actual);
    }

    @Test
    public void testSomeZeroCase(){
        int[] testCase1 = new int [] { 0 };
        int[] testCase2 = new int [] { 0, 2, 3 };
        long expected1 = 0;
        long expected2 = 0;
        long actual1 = Toolkit.product(testCase1);
        long actual2 = Toolkit.product(testCase2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testAllNoneZeroCase(){
        int[] testCase1 = new int [] { 1 };
        int[] testCase2 = new int [] { 5, 2, 3 };
        long expected1 = 1;
        long expected2 = 30;
        long actual1 = Toolkit.product(testCase1);
        long actual2 = Toolkit.product(testCase2);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }
}
