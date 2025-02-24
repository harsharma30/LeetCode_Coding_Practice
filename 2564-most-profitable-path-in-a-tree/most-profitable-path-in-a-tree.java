class Solution {

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length, maxIncome = Integer.MIN_VALUE;
        tree = new ArrayList<>();
        bobPath = new HashMap<>();
        visited = new boolean[n];
        Queue<int[]> nodeQueue = new LinkedList<>();
        nodeQueue.add(new int[] { 0, 0, 0 });
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        findBobPath(bob, 0);

        Arrays.fill(visited, false);
        while (!nodeQueue.isEmpty()) {
            int[] node = nodeQueue.poll();
            int sourceNode = node[0], time = node[1], income = node[2];

            if (
                !bobPath.containsKey(sourceNode) ||
                time < bobPath.get(sourceNode)
            ) {
                income += amount[sourceNode];
            }
            else if (time == bobPath.get(sourceNode)) {
                income += amount[sourceNode] / 2;
            }

            if (tree.get(sourceNode).size() == 1 && sourceNode != 0) {
                maxIncome = Math.max(maxIncome, income);
            }
            for (int adjacentNode : tree.get(sourceNode)) {
                if (!visited[adjacentNode]) {
                    nodeQueue.add(new int[] { adjacentNode, time + 1, income });
                }
            }

            visited[sourceNode] = true;
        }
        return maxIncome;
    }

    private Map<Integer, Integer> bobPath;
    private boolean[] visited;
    private List<List<Integer>> tree;

    private boolean findBobPath(int sourceNode, int time) {
        bobPath.put(sourceNode, time);
        visited[sourceNode] = true;

        if (sourceNode == 0) {
            return true;
        }
        for (int adjacentNode : tree.get(sourceNode)) {
            if (!visited[adjacentNode]) {
                if (findBobPath(adjacentNode, time + 1)) {
                    return true;
                }
            }
        }
        bobPath.remove(sourceNode);
        return false;
    }
}