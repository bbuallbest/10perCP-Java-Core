package org.bbuallbest.random.shuffle;

public class ArrayGenerator {

    private ArrayGenerator() {}

    public static int[] generateIntArray1D(int size) {
        validateSize(size);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[][] generateIntArray2D(int size) {
        validateSize(size);
        int[][] array = new int[size][];
        for (int i = 0; i < size; i++) {
            array[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                array[i][j] = j;
            }
        }
        return array;
    }

    private static void validateSize(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Illegal argument 'size': " + size);
    }
}
