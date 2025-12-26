class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int k=0; k<nums.length; k++){
            nums[k] = nums[k]*nums[k];
        }
        Arrays.sort(nums);
        return nums;
    }   
}