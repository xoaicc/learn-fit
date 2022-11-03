package SE1Tutorial.Tut06.ToolkitTest;

import SE1Tutorial.Tut06.ToolkitTest.Toolkit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemainderTest {
    private  static final int[][] EXCEPTOPNAL_CASES = {
            {0, 0},
            {1, 0}
    };

    private  static final int[][] OTHER_CASES_1 = {
            {5, 2, 1},
            {5, 10, 5},
    };

    private  static final int[][] OTHER_CASES_2 = {
            {5, -2, 1},
            {5, -10, 5},
    };

    private  static final int[][] OTHER_CASES_3 = {
            {-5, 2, 1},
            {-5, 10 , 5},
    };

    private  static final int[][] OTHER_CASES_4 = {
            {-5, -2, 1},
            {-5, -10 , 5},

    };

    @Test
    public void testProductInExceptionalCases()
            throws AssertionError{
        for (int[] testcase : EXCEPTOPNAL_CASES) {
            int x = testcase[0];
            int y = testcase[1];

            try{
                Toolkit.remainder(x, y);
                throw new AssertionError(String.format(
                        "TC (%s, %s) failed, reason : No exception observed.",
                        x,y
                ));
            }catch (Exception e){
                //
            }
        }
    }

    @Test
    public void testRemainderInOtherCases1()
            throws  AssertionError{
        int[][] testCases = OTHER_CASES_1;
        runTestOn(testCases);
    }

    @Test
    public void testRemainderInOtherCases2()
            throws  AssertionError{
        int[][] testCases = OTHER_CASES_2;
        runTestOn(testCases);
    }

    @Test
    public void testRemainderInOtherCases3()
            throws  AssertionError{
        int[][] testCases = OTHER_CASES_3;
        runTestOn(testCases);
    }

 
    @Test
    public void testRemainderInOtherCases4()
        throws  AssertionError{
        int[][] testCases = OTHER_CASES_4;
        runTestOn(testCases);
    }

    private void runTestOn(int[][] testCases) {
        for (int[] testCase: testCases) {
            int x = testCase[0];
            int y = testCase[1];
            int expected = testCase[2];
            int actual = Toolkit.remainder(x, y);
            String failMessage = (String.format(
                    "TC (%s, %s) failed, reason : Expected %s but actual %s",
                    x,y, expected, actual
            ));
            assertEquals(failMessage, expected, actual);
        }
    }
}
