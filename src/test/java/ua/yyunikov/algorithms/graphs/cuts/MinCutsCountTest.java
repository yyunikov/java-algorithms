package ua.yyunikov.algorithms.graphs.cuts;

import org.junit.Assert;
import org.junit.Test;
import ua.yyunikov.algorithms.AlgorithmTest;
import ua.yyunikov.algorithms.util.FileUtils;

import java.io.IOException;

public class MinCutsCountTest extends AlgorithmTest {

    @Test
    public void testRandomContraction() {
        testMinimumCuts("Random Contraction", new RandomContractionMinCutsCount());
    }

    private void testMinimumCuts(final String algorithmName, final MinCutsCount minCutsCount) {
        runningTimeOf(algorithmName, () -> {
            // test 1
            int minResult = Integer.MAX_VALUE;

            for (int i = 0; i < 1000; i++) {
                final int result = minCutsCount.count(new int[][]{
                        {2, 3, 4},
                        {1, 3},
                        {1, 2, 4},
                        {1, 3}
                });
                if (result < minResult) {
                    minResult = result;
                }
            }

            Assert.assertEquals(2, minResult);

            // test 2
            try {
                final int[][] array = FileUtils.twoDimensionalArray("src/test/java/ua/yyunikov/algorithms/graphs/cuts/kargerMinCut.txt");
                int minResult2 = Integer.MAX_VALUE;
                for (final int[] anArray : array) {
                    final int result = minCutsCount.count(array);
                    if (result < minResult2) {
                        minResult2 = result;
                    }
                }

                Assert.assertEquals(17, minResult2);
            } catch (final IOException e) {
                System.err.println("Unexpected error: " + e);
            }
        });
    }
}
