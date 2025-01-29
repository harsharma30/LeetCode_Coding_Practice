class Solution {
    private int calculateFishes(
        int[][] grid,
        boolean[][] visited,
        int row,
        int col
    ) {
        if (
            row < 0 ||
            row >= grid.length ||
            col < 0 ||
            col >= grid[0].length ||
            grid[row][col] == 0 ||
            visited[row][col]
        ) {
            return 0;
        }

        visited[row][col] = true;

        return (
            grid[row][col] +
            calculateFishes(grid, visited, row, col + 1) +
            calculateFishes(grid, visited, row, col - 1) +
            calculateFishes(grid, visited, row + 1, col) +
            calculateFishes(grid, visited, row - 1, col)
        );
    }

    public int findMaxFish(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxFishCount = 0;

        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] > 0 && !visited[row][col]) {
                    maxFishCount = Math.max(
                        maxFishCount,
                        calculateFishes(grid, visited, row, col)
                    );
                }
            }
        }

        return maxFishCount;
    }
}