package SE1Tutorial.Tut06.ToolkitTest;

import SE1Tutorial.Tut06.ToolkitTest.Toolkit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SubStringTest {
    @Test
    public void testNullString(){
        String testCase = null;
        int startPos = 3;
        int endPos = 5;
        try{
            Toolkit.subString(testCase, startPos, endPos);
            throw new IllegalArgumentException(String.format("Toolkit.subString(%s, %d, %d)", testCase, startPos, endPos));
        }catch (Exception e){
        }
    }

    @Test
    public void testEmptyString(){
        String testCase = "";
        int startPos = 1;
        int endPos = 3;
        try{
            Toolkit.subString(testCase, startPos, endPos);
            throw new IllegalArgumentException(String.format("Toolkit.subString(%s, %d, %d)", testCase, startPos, endPos));
        }catch (Exception e){
        }
    }

    @Test
    public void testNegativeStartPos(){
        String testCase = "null";
        int startPos = -1;
        int endPos = 3;
        try{
            Toolkit.subString(testCase, startPos, endPos);
            throw new IllegalArgumentException(String.format("Toolkit.subString(%s, %d, %d)", testCase, startPos, endPos));
        }catch (Exception e){
        }
    }

    @Test
    public void testNegativeEndPos(){
        String testCase = "null";
        int startPos = 1;
        int endPos = -3;
        try{
            Toolkit.subString(testCase, startPos, endPos);
            throw new IllegalArgumentException(String.format("Toolkit.subString(%s, %d, %d)", testCase, startPos, endPos));
        }catch (Exception e){
        }
    }

    @Test
    public void testBothNegativePos(){
        String testCase = "null";
        int startPos = -1;
        int endPos = -3;
        try{
            Toolkit.subString(testCase, startPos, endPos);
            throw new IllegalArgumentException(String.format("Toolkit.subString(%s, %d, %d)", testCase, startPos, endPos));
        }catch (Exception e){
        }
    }

    @Test
    public void testEndPosSmallerStartPos(){
        String testCase = "null";
        int startPos = 3;
        int endPos = 1;
        try{
            Toolkit.subString(testCase, startPos, endPos);
            throw new IllegalArgumentException(String.format("Toolkit.subString(%s, %d, %d)", testCase, startPos, endPos));
        }catch (Exception e){
        }
    }

    @Test
    public void testNormalString(){
        String testCase = "null";
        int startPos = 1;
        int endPos = 3;
        String expected = testCase.substring(startPos, endPos);
        String actual = Toolkit.subString(testCase, startPos, endPos);
        assertEquals(expected, actual);
    }

}
