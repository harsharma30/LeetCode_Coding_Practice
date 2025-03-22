public class Solution {

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Map<List<Integer>, Integer> componentFreq = new HashMap<>();

        for (int vertex = 0; vertex < n; vertex++) {
            graph[vertex] = new ArrayList<>();
            graph[vertex].add(vertex);
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        for (int vertex = 0; vertex < n; vertex++) {
            List<Integer> neighbors = graph[vertex];
            Collections.sort(neighbors);
            componentFreq.put(
                neighbors,
                componentFreq.getOrDefault(neighbors, 0) + 1
            );
        }

        int completeCount = 0;
        for (Map.Entry<
            List<Integer>,
            Integer
        > entry : componentFreq.entrySet()) {
            if (entry.getKey().size() == entry.getValue()) {
                completeCount++;
            }
        }

        return completeCount;
    }
}