class Solution {

    public int trapRainWater(int[][] heightMap) {
        int[] dRow = { 0, 0, -1, 1 };
        int[] dCol = { -1, 1, 0, 0 };

        int numOfRows = heightMap.length;
        int numOfCols = heightMap[0].length;

        boolean[][] visited = new boolean[numOfRows][numOfCols];

        PriorityQueue<Cell> boundary = new PriorityQueue<>();

        for (int i = 0; i < numOfRows; i++) {
            boundary.offer(new Cell(heightMap[i][0], i, 0));
            boundary.offer(
                new Cell(heightMap[i][numOfCols - 1], i, numOfCols - 1)
            );
            visited[i][0] = visited[i][numOfCols - 1] = true;
        }

        for (int i = 0; i < numOfCols; i++) {
            boundary.offer(new Cell(heightMap[0][i], 0, i));
            boundary.offer(
                new Cell(heightMap[numOfRows - 1][i], numOfRows - 1, i)
            );
            visited[0][i] = visited[numOfRows - 1][i] = true;
        }

        int totalWaterVolume = 0;

        while (!boundary.isEmpty()) {
            Cell currentCell = boundary.poll();

            int currentRow = currentCell.row;
            int currentCol = currentCell.col;
            int minBoundaryHeight = currentCell.height;

            for (int direction = 0; direction < 4; direction++) {
                int neighborRow = currentRow + dRow[direction];
                int neighborCol = currentCol + dCol[direction];

                if (
                    isValidCell(
                        neighborRow,
                        neighborCol,
                        numOfRows,
                        numOfCols
                    ) &&
                    !visited[neighborRow][neighborCol]
                ) {
                    int neighborHeight = heightMap[neighborRow][neighborCol];

                    if (neighborHeight < minBoundaryHeight) {
                        totalWaterVolume += minBoundaryHeight - neighborHeight;
                    }

                    boundary.offer(
                        new Cell(
                            Math.max(neighborHeight, minBoundaryHeight),
                            neighborRow,
                            neighborCol
                        )
                    );
                    visited[neighborRow][neighborCol] = true;
                }
            }
        }

        return totalWaterVolume;
    }

    private static class Cell implements Comparable<Cell> {

        int height;
        int row;
        int col;

        public Cell(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Cell other) {
            return Integer.compare(this.height, other.height);
        }
    }

    private boolean isValidCell(
        int row,
        int col,
        int numOfRows,
        int numOfCols
    ) {
        return row >= 0 && col >= 0 && row < numOfRows && col < numOfCols;
    }
}