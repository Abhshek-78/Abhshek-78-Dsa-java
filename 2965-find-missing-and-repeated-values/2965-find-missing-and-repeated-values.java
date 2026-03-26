import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Set<Integer> s = new HashSet<>();
        int repeated = 0, missing;
        int actualSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                actualSum += val;
                if (s.contains(val)) {
                    repeated = val;
                }
                s.add(val);
            }
        }

        int expectedSum = (n * n) * (n * n + 1) / 2;
        missing = expectedSum - actualSum + repeated;

        return new int[ ]{repeated, missing};
    }
}