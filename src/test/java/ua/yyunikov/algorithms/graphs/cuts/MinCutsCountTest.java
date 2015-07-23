package ua.yyunikov.algorithms.graphs.cuts;

import org.junit.Assert;
import org.junit.Test;
import ua.yyunikov.algorithms.AlgorithmTest;

public class MinCutsCountTest extends AlgorithmTest {

    @Test
    public void testRandomContraction() {
        testMinimumCuts("Random Contraction", new RandomContractionMinCutsCount());
    }

    private void testMinimumCuts(final String algorithmName, final MinCutsCount minCutsCount) {
        runningTimeOf(algorithmName, () -> {
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
        });
    }
}
