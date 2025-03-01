class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int r=0;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                r=nums[i];
            }
        }
        return r;
    }
}