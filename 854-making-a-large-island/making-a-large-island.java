class Solution {

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2;
        for (int currentRow = 0; currentRow < grid.length; ++currentRow) {
            for (
                int currentColumn = 0;
                currentColumn < grid[0].length;
                ++currentColumn
            ) {
                if (grid[currentRow][currentColumn] == 1) {
                    islandSizes.put(
                        islandId,
                        exploreIsland(grid, islandId, currentRow, currentColumn)
                    );
                    ++islandId;
                }
            }
        }
        if (islandSizes.isEmpty()) {
            return 1;
        }
        if (islandSizes.size() == 1) {
            --islandId;
            return (islandSizes.get(islandId) == grid.length * grid[0].length)
                ? islandSizes.get(islandId)
                : islandSizes.get(islandId) + 1;
        }

        int maxIslandSize = 1;
        for (int currentRow = 0; currentRow < grid.length; ++currentRow) {
            for (
                int currentColumn = 0;
                currentColumn < grid[0].length;
                ++currentColumn
            ) {
                if (grid[currentRow][currentColumn] == 0) {
                    int currentIslandSize = 1;
                    Set<Integer> neighboringIslands = new HashSet<>();
                    if (
                        currentRow + 1 < grid.length &&
                        grid[currentRow + 1][currentColumn] > 1
                    ) {
                        neighboringIslands.add(
                            grid[currentRow + 1][currentColumn]
                        );
                    }
                    if (
                        currentRow - 1 >= 0 &&
                        grid[currentRow - 1][currentColumn] > 1
                    ) {
                        neighboringIslands.add(
                            grid[currentRow - 1][currentColumn]
                        );
                    }
                    if (
                        currentColumn + 1 < grid[0].length &&
                        grid[currentRow][currentColumn + 1] > 1
                    ) {
                        neighboringIslands.add(
                            grid[currentRow][currentColumn + 1]
                        );
                    }
                    if (
                        currentColumn - 1 >= 0 &&
                        grid[currentRow][currentColumn - 1] > 1
                    ) {
                        neighboringIslands.add(
                            grid[currentRow][currentColumn - 1]
                        );
                    }
                    for (int id : neighboringIslands) {
                        currentIslandSize += islandSizes.get(id);
                    }

                    maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
                }
            }
        }

        return maxIslandSize;
    }

    private int exploreIsland(
        int[][] grid,
        int islandId,
        int currentRow,
        int currentColumn
    ) {
        if (
            currentRow < 0 ||
            currentRow >= grid.length ||
            currentColumn < 0 ||
            currentColumn >= grid[0].length ||
            grid[currentRow][currentColumn] != 1
        ) return 0;

        grid[currentRow][currentColumn] = islandId;
        return (
            1 +
            exploreIsland(grid, islandId, currentRow + 1, currentColumn) +
            exploreIsland(grid, islandId, currentRow - 1, currentColumn) +
            exploreIsland(grid, islandId, currentRow, currentColumn + 1) +
            exploreIsland(grid, islandId, currentRow, currentColumn - 1)
        );
    }
}