package ua.yyunikov.algorithms.sort;

import ua.yyunikov.algorithms.util.ArrayUtils;

/**
 * <a href="https://en.wikipedia.org/wiki/Merge_sort">Merge sort</a> algorithm. Running time of n*log(n).
 */
public class MergeSort extends Sort {

    @Override
    protected int[] doSort(final int[] array) {
        if (array.length > 1) {
            final int[][] splittedArray = ArrayUtils.split(array);
            final int[] leftPart = doSort(splittedArray[0]); // left part
            final int[] rightPart = doSort(splittedArray[1]); // right part
            return merge(leftPart, rightPart);
        }

        return array;
    }

    private int[] merge(final int[] leftPart, final int[] rightPart) {
        final int fullLength = leftPart.length + rightPart.length;
        final int[] mergeResult = new int[fullLength];
        int i = 0;
        int j = 0;

        for (int counter = 0; counter < fullLength; counter++) {
            // j can exceed the right part length so if yes, we just add all from the left part
            if (j >= rightPart.length || i < leftPart.length && leftPart[i] < rightPart[j]) {
                mergeResult[counter] = leftPart[i];
                i++;
            } else { // i can exceed the left part length so if yes, we just add all from the right part
                mergeResult[counter] = rightPart[j];
                j++;
            }
        }

        return mergeResult;
    }
}
