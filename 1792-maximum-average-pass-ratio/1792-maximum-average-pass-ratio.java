class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(o -> -o[0])); // Max heap compared by first value in decreasing order.
        for (int[] c : classes) {
            double a = c[0], b = c[1];
            maxHeap.offer(new double[]{profit(a, b), a, b});
        }
        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            double a = top[1], b = top[2];
            maxHeap.offer(new double[]{profit(a+1, b+1), a+1, b+1});
        }
        double ans = 0.0d;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            double a = top[1], b = top[2];
            ans += a/b;
        }
        return ans / classes.length;
    }
    double profit(double a, double b) {
        return (a + 1) / (b + 1) - a / b;
    }
}