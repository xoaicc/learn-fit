package SE1Tutorial.Tut06.ToolkitTest;

import SE1Tutorial.Tut06.ToolkitTest.Toolkit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestSum {
    @Test
    public void testNullArray(){
        int[] testCase = null;
        long expected = -1;
        long actual = Toolkit.sum(testCase);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyArray(){
        int[] testCase = new int[0];
        long expected = -1;
        long actual = Toolkit.sum(testCase);
        assertEquals(expected, actual);
    }

    @Test
    public void testNonNullAndNonEmptyArray(){
        int[] testCase = {0, 1, -3, 5, -6};
        long expected = -3;
        long actual = Toolkit.sum(testCase);
        assertEquals(expected, actual);
    }
}
