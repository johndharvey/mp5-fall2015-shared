package ca.ece.ubc.cpen221.mp5.query;

import static org.junit.Assert.*;
import org.junit.Test;

public class RQueryFactoryTest {

    @Test
    public void test1() {
        RQuery test = RQueryFactory.parse("category(Italian)");
        assertTrue(test.containsCategory("Italian"));
    }

}
