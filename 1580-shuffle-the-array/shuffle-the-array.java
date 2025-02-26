class Solution {
    public int[] shuffle(int[] nums, int n) {
        int start = 0, mid = n, index = 0;
        int l = nums.length;
        int[] ans = new int[l];
        while(mid < l){
            ans[index++] = nums[start++];
            ans[index++] = nums[mid++];
        }
        return ans;
    }
}