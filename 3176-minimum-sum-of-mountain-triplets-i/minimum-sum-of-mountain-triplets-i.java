class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int ans = 1000000005;
        for(int i = 0; i < n - 2; i++)
            for(int j = i + 1; j < n - 1; ++j)
                if(nums[i] < nums[j])
                    for(int k = j + 1; k < n; ++k)
                        if(nums[k] < nums[j])
                            ans = Math.min(ans, (nums[i] + nums[j] + nums[k]));

        return ans == 1000000005  ? -1 : ans;
    }
}