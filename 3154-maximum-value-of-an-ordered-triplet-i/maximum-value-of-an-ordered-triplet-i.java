class Solution {
    public long maximumTripletValue(int[] nums) {
        long cValue=0;
        long mValue=0;
     for(int i=0;i<nums.length-2;i++){
        for(int j=i+1;j<nums.length-1;j++){
            for(int k=j+1;k<nums.length;k++){
                cValue=(long)(nums[i]-nums[j])*nums[k];
                mValue=Math.max(cValue,mValue);

            }
        }
     } 
     return mValue;  
    }
}