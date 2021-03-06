package com.yunikov.algorithms;

import org.junit.BeforeClass;

import java.util.Arrays;
import java.util.Random;

public abstract class AlgorithmTest {

    protected static final int MILLION = 1000000;
    protected static final int TEN_THOUSAND = 10000;

    @BeforeClass
    public static void warmUp() throws InterruptedException {
        // warming up for 2 seconds to make running time more precise
        Thread.sleep(2000);
    }

    protected static int[] generateRandomArray(final int size) {
        final int[] bigArray = new int[size];
        final Random random = new Random();

        for(int i = 0; i < size; i++) {
            bigArray[i] = random.nextInt();
        }

        return bigArray;
    }

    protected static int[] javaSort(final int[] array) {
        final int[] copy = array.clone();
        Arrays.sort(copy);
        return copy;
    }

    public AlgorithmTest runningTimeOf(final String algorithmName, final AlgorithmExecutor algorithmExecutor) {
        final long startTime = System.currentTimeMillis();

        algorithmExecutor.execute();

        final long endTime = System.currentTimeMillis();
        System.out.println(algorithmName + " running time: " + (endTime - startTime) / 1000.0);

        return this;
    }

    public void asserting(final AlgorithmAssert algorithmAssert) {
        algorithmAssert.assertAlgorithm();
    }
}
