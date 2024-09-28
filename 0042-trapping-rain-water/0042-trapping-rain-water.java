class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int maxLeft = 0;
        int maxRight = 0;

        // Calculate left max
        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            leftMax[i] = maxLeft;
        }

        // Calculate right max
        for (int i = n - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            rightMax[i] = maxRight;
        }

        // Calculate trapped water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trappedWater;
    }
}