class Solution {
    public int findDuplicate(int[] nums) {
        int l = nums.length;
        int ret = 0;
        for(int i=0; i<l; i++){
            if(nums[Math.abs(nums[i])] < 0){
                ret = Math.abs(nums[i]);
                break;
            }
            nums[Math.abs(nums[i])] = nums[Math.abs(nums[i])] * -1;
        } 
        return ret;
    }
}