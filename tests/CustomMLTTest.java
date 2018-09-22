import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Кирилл on 22.09.2018.
 */
public class CustomMLTTest {
    @Test
    public void multipleWithoutOperator() throws Exception {
        assertEquals(4, CustomMLT.multipleWithoutOperator(2, 2));
        assertEquals(-4, CustomMLT.multipleWithoutOperator(2, -2));
        assertEquals(-4, CustomMLT.multipleWithoutOperator(-2, 2));
        assertEquals(4, CustomMLT.multipleWithoutOperator(-2, -2));
        assertEquals(0, CustomMLT.multipleWithoutOperator(2, 0));
        assertEquals(0, CustomMLT.multipleWithoutOperator(0, 2));
        assertEquals(0, CustomMLT.multipleWithoutOperator(0, 0));
    }

}