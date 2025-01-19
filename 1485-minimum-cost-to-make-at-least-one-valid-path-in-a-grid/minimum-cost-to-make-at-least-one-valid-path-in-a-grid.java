class Solution {

    public int minCost(int[][] grid) {
        int numRows = grid.length, numCols = grid[0].length;
        int[][] minChanges = new int[numRows][numCols];

        for (int[] row : minChanges) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minChanges[0][0] = 0;

        while (true) {
            int[][] prevState = new int[numRows][numCols];
            for (int row = 0; row < numRows; row++) {
                prevState[row] = Arrays.copyOf(minChanges[row], numCols);
            }

            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    
                    if (row > 0) {
                        minChanges[row][col] = Math.min(
                            minChanges[row][col],
                            minChanges[row - 1][col] +
                            (grid[row - 1][col] == 3 ? 0 : 1)
                        );
                    }
                    if (col > 0) {
                        minChanges[row][col] = Math.min(
                            minChanges[row][col],
                            minChanges[row][col - 1] +
                            (grid[row][col - 1] == 1 ? 0 : 1)
                        );
                    }
                }
            }

            for (int row = numRows - 1; row >= 0; row--) {
                for (int col = numCols - 1; col >= 0; col--) {
                    if (row < numRows - 1) {
                        minChanges[row][col] = Math.min(
                            minChanges[row][col],
                            minChanges[row + 1][col] +
                            (grid[row + 1][col] == 4 ? 0 : 1)
                        );
                    }
                    if (col < numCols - 1) {
                        minChanges[row][col] = Math.min(
                            minChanges[row][col],
                            minChanges[row][col + 1] +
                            (grid[row][col + 1] == 2 ? 0 : 1)
                        );
                    }
                }
            }
            if (Arrays.deepEquals(prevState, minChanges)) {
                break;
            }
        }

        return minChanges[numRows - 1][numCols - 1];
    }
}