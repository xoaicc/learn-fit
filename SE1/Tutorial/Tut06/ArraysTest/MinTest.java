package SE1Tutorial.Tut06.ArraysTest;

import SE1Tutorial.Tut06.ArraysTest.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MinTest {
    @Test
    public void testNullArray(){
        int[] testCase = null;
        try{
            Arrays.min(testCase);
            throw new IllegalArgumentException(String.format(
                    "TC (%s) failed, reason : No exception observed.",testCase));
        }catch (Exception e){
        }
    }

    @Test
    public void testEmptyArray(){
        int[] testCase = new int[0];
        try{
            Arrays.min(testCase);
            throw new IllegalArgumentException(String.format(
                    "TC (%s) failed, reason : No exception observed.",testCase));
        }catch (Exception e){
        }
    }

    @Test
    public void testNormalArray(){
        int[] testCase = {1, -3, 5, 6};
        long expected = -3;
        long actual = Arrays.min(testCase);
        assertEquals(expected, actual);
    }

}
