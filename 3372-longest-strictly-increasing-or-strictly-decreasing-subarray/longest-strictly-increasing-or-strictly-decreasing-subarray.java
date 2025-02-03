class Solution {

    public int longestMonotonicSubarray(int[] nums) {
        int maxLength = 0;
        for (int start = 0; start < nums.length; start++) {
            int currLength = 1;
            for (int pos = start + 1; pos < nums.length; pos++) {
                if (nums[pos] > nums[pos - 1]) {
                    currLength++;
                } else {
                    break;
                }
            }
            maxLength = Math.max(maxLength, currLength);
        }
        for (int start = 0; start < nums.length; start++) {
            int currLength = 1;
            for (int pos = start + 1; pos < nums.length; pos++) {
                if (nums[pos] < nums[pos - 1]) {
                    currLength++;
                } else {
                    break;
                }
            }
            maxLength = Math.max(maxLength, currLength);
        }

        return maxLength;
    }
}