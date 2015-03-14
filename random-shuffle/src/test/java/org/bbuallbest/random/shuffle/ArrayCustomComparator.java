package org.bbuallbest.random.shuffle;

import java.util.Objects;

public class ArrayCustomComparator {

    private ArrayCustomComparator() {}

    public static boolean isArray1DEqualsOn75PercentOrGreater(int[] a1, int[] a2) {
        validateArrays1D(a1, a2);
        return compareArrays(a1, a2);
    }

    public static boolean isArray2DEqualsOn75PercentOrGreater(int[][] a1, int[][] a2) {
        validateArrays2D(a1, a2);
        for (int i = 0; i < a1.length ; i++) {
            validateArrays1D(a1[i], a2[i]);
            if(!compareArrays(a1[i], a2[i]))
                return false;
        }
        return true;
    }

    private static boolean compareArrays(int[] a1, int[] a2) {
        int equalElementCounter = 0;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] == a2[i])
                equalElementCounter++;
        }
        int quarter = calculateQuarter(a1.length);
        return equalElementCounter >= a1.length - quarter;
    }

    private static int calculateQuarter(int length) {
        return length / 4;
    }

    private static void validateArrays1D(int[] a1, int[] a2) {
        Objects.requireNonNull(a1, "Array 'a1' is null");
        Objects.requireNonNull(a2, "Array 'a2' is null");
        if (a1.length != a2.length)
            throw new IllegalArgumentException("Array sizes are not equal: " + a1.length + " != " + a2.length);
    }

    private static void validateArrays2D(int[][] a1, int[][] a2) {
        Objects.requireNonNull(a1, "Array 'a1' is null");
        Objects.requireNonNull(a2, "Array 'a2' is null");
        if (a1.length != a2.length)
            throw new IllegalArgumentException("Array sizes are not equal: " + a1.length + " != " + a2.length);
    }
}
