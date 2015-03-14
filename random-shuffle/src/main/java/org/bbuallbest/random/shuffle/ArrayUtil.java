package org.bbuallbest.random.shuffle;

import java.util.Arrays;
import java.util.Objects;

public class ArrayUtil {

    private static final int MIN_SIZE_THAT_ALLOW_SHUFFLING = 8;
    private static final int MIN_AMOUNT_OF_1D_ARRAYS = 1;

    private static final String VALIDATION_NPE_MESSAGE = "Input argument 'array' is null.";

    private ArrayUtil() {}

    public static int[] randomQuarterShuffleForArray1D(int[] array) {
        Objects.requireNonNull(array, VALIDATION_NPE_MESSAGE);
        if(array.length < MIN_SIZE_THAT_ALLOW_SHUFFLING)
            return array;
        int[] shuffledArray = Arrays.copyOf(array, array.length);
        randomQuarterShuffle(shuffledArray);
        return shuffledArray;
    }

    public static int[][] randomQuarterShuffleForArray2D(int[][] array) {
        Objects.requireNonNull(array, VALIDATION_NPE_MESSAGE);
        if(array.length < MIN_AMOUNT_OF_1D_ARRAYS)
            return array;
        int[][] shuffledArray2D = copyArray2D(array);
        for (int[] array1D : shuffledArray2D) {
            if (shuffledArray2D != null && shuffledArray2D.length > MIN_SIZE_THAT_ALLOW_SHUFFLING) {
                randomQuarterShuffle(array1D);
            }
        }
        return shuffledArray2D;
    }

    private static void randomQuarterShuffle(int[] array) {
        int quarterLength = calculateQuarterLength(array.length);
        int startIndex = generateRandomIntFromZeroTo(array.length - quarterLength);
        shuffle(array, startIndex, quarterLength);
    }

    private static void shuffle(int[] array, int startIndex, int length) {
        int from, to;
        for (int i = 0; i < length; i++) {
            from = startIndex + generateRandomIntFromZeroTo(length);
            to = startIndex + generateRandomIntFromZeroTo(length);
            swap(array, from, to);
        }
    }

    private static int generateRandomIntFromZeroTo(int value) {
        return (int)(Math.random() * value);
    }

    private static int calculateQuarterLength(int length) {
        return length / 4;
    }

    private static void swap(int[] array, int from, int to) {
        int temp = array[to];
        array[to] = array[from];
        array[from] = temp;
    }

    public static int[][] copyArray2D(int[][] array) {
        Objects.requireNonNull(array, VALIDATION_NPE_MESSAGE);
        int[][] newArray = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                newArray[i] = Arrays.copyOf(array[i], array[i].length);
            }
        }
        return newArray;
    }
}
