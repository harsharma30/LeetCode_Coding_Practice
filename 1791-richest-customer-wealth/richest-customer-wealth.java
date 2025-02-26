import java.util.Arrays;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int[] wealth = new int[m];

        for (int i = 0; i < m; i++) {
            int sum = 0;
            int n = accounts[i].length;

            for (int j = 0; j < n; j++) {
                sum += accounts[i][j];
            }

            wealth[i] = sum;
        }

        Arrays.sort(wealth);
        return wealth[m - 1];
    }
}
