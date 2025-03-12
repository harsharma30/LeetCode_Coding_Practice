class Solution {
    public int maximumCount(int[] nums) {
        int positive = 0;
        int negative = 0;
        int ans;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                positive++;
            }
            else if(nums[i]<0){
                negative++;
            }
        }
        if(positive > negative){
            ans = positive;
        }
        else{
            ans = negative;
        }

        return ans;
    }
}