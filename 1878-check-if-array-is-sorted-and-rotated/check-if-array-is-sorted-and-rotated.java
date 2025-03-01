class Solution {
    public boolean check(int[] nums) {
        int l = nums.length;
        int count = 0;
        for(int i=1; i<l; i++){
            if(nums[i]<nums[i-1]){
                count++;
            }
        }
        if(nums[0]<nums[l-1]){
            count++;
        }
        return count<=1;
    }
}