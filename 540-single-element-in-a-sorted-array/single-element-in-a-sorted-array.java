class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans=0;
        for(int i=0; i<nums.length; i++){

            if(i<nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }
            else{
                ans = nums[i];
            }
        }
        return ans;
    }
}