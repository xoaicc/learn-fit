package SE1Tutorial.Tut06.ToolkitTest;

import SE1Tutorial.Tut06.ToolkitTest.Toolkit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LenStringTest {
    @Test
    public void testNullString(){
        String testCase = null;
        try{
            Toolkit.lenString(testCase);
            throw new IllegalArgumentException(String.format(
                    "TC (%s) failed, reason : No exception observed.",testCase));
        }catch (Exception e){

        }
    }

    @Test
    public void testEmptyString(){
        String testCase = "";
        int expected = 0;
        int actual = Toolkit.lenString(testCase);
        assertEquals(expected, actual);
    }

    @Test
    public void testNormalString(){
        String testCase = "null";
        int expected = 4;
        int actual = Toolkit.lenString(testCase);
        assertEquals(expected, actual);
    }
}
