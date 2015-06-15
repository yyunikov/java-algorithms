package ua.yyunikov.algorithms.sort;

import ua.yyunikov.algorithms.util.ArrayUtils;

public class InsertionSort extends Sort {

    @Override
    protected int[] doSort(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j -= 1) {
                ArrayUtils.swap(array, j, j - 1);
            }
        }

        return array;
    }
}