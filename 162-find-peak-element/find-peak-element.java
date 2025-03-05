class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                ans = i;
            }
        }

        return ans;
    }
}
