class Solution {

    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int left = 0, right = 0;
        int n = nums.length;
        long count = 0;

        while (right < n) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}