import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        
        for (int i = 0; i < n; i++)
            sum += nums[i];
        
        if (sum % 2 != 0) 
            return false;

        boolean[] dp = new boolean[10001];
        dp[0] = true;
        for (int num : nums) {
            for (int j = 10000; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
            if (dp[sum / 2]) 
                return true;
        }
        return dp[sum / 2];
    }
}