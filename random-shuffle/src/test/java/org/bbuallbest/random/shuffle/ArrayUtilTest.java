package org.bbuallbest.random.shuffle;

import static org.junit.Assert.*;
import static org.bbuallbest.random.shuffle.ArrayCustomComparator.*;
import org.junit.Before;
import org.junit.Test;

public class ArrayUtilTest {

    private static final int ARRAY_SIZE = 20;

    private int[] testArray1D;
    private int[][] testArray2D;

    @Test
    public void testSuccessfulRandomQuarterShuffleForArray1D() {
        int[] actual = ArrayUtil.randomQuarterShuffleForArray1D(testArray1D);
        assertTrue(isArray1DEqualsOn75PercentOrGreater(actual, testArray1D));
    }

    @Test
    public void testSuccessfulRandomQuarterShuffleForArray2D() {
        int[][] actual = ArrayUtil.randomQuarterShuffleForArray2D(testArray2D);
        assertTrue(isArray2DEqualsOn75PercentOrGreater(actual, testArray2D));
    }

    @Test(expected = NullPointerException.class)
    public void testOnNPExceptionInRandomQuarterShuffleForArray1D() {
        ArrayUtil.randomQuarterShuffleForArray1D(null);
    }

    @Test(expected = NullPointerException.class)
    public void testOnNPExceptionInRandomQuarterShuffleForArray2D() {
        ArrayUtil.randomQuarterShuffleForArray2D(null);
    }

    @Before
    public void setUp() throws Exception {
        testArray1D = ArrayGenerator.generateIntArray1D(ARRAY_SIZE);
        testArray2D = ArrayGenerator.generateIntArray2D(ARRAY_SIZE);
    }
}
