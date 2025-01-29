class Solution {
    private boolean isConnected(
        int src,
        int target,
        boolean[] visited,
        List<Integer>[] adjList
    ) {
        visited[src] = true;

        if (src == target) {
            return true;
        }

        boolean isFound = false;
        for (int adj : adjList[src]) {
            if (!visited[adj]) {
                isFound = isFound || isConnected(adj, target, visited, adjList);
            }
        }

        return isFound;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;

        List<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            boolean[] visited = new boolean[N];
            if (isConnected(edge[0] - 1, edge[1] - 1, visited, adjList)) {
                return new int[] { edge[0], edge[1] };
            }

            adjList[edge[0] - 1].add(edge[1] - 1);
            adjList[edge[1] - 1].add(edge[0] - 1);
        }

        return new int[] {};
    }
}