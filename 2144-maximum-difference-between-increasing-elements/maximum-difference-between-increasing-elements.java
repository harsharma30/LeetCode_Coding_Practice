class Solution {

    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1, p = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > p) {
                ans = Math.max(ans, nums[i] - p);
            } else {
                p = nums[i];
            }
        }
        return ans;
    }
}