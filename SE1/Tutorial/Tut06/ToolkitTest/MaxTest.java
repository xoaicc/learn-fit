package SE1Tutorial.Tut06.ToolkitTest;

import SE1Tutorial.Tut06.ToolkitTest.Toolkit;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaxTest {
    @Test
    public void testEqualsNumber(){
        double x = 5d;
        double y = 5d;
        double expected = x;
        double actual = Toolkit.max(x, y);
        assertEquals(expected, actual, 0);
    }

    public void testOppositeSign(){
        double x = -5d;
        double y = 5d;
        double expected = y;
        double actual = Toolkit.max(x, y);
        assertEquals(expected, actual, 0);
    }


}
