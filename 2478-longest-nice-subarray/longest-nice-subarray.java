class Solution {

    public int longestNiceSubarray(int[] nums) {
        int left = 0, right = nums.length;
        int result = 1;

        while (left <= right) {
            int length = left + (right - left) / 2;
            if (canFormNiceSubarray(length, nums)) {
                result = length;
                left = length + 1;
            } else {
                right = length - 1; 
            }
        }
        return result;
    }

    private boolean canFormNiceSubarray(int length, int[] nums) {
        if (length <= 1) return true;

        for (int start = 0; start <= nums.length - length; ++start) {
            int bitMask = 0;
            boolean isNice = true;

            for (int pos = start; pos < start + length; ++pos) {

                if ((bitMask & nums[pos]) != 0) {
                    isNice = false;
                    break;
                }
                bitMask |= nums[pos];
            }

            if (isNice) return true; 
        }
        return false; 
    }
}