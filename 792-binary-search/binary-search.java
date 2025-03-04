class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while(low <= high){
            mid = low+(high-low)/2;
            if(nums[mid] == target){
            return mid;
            }
            else if(nums[mid]>target){
                low = 0;
                high = mid-1;
            }
            else if(nums[mid]<target){
                low = mid+1;
                high = high;
            }
        }
        return -1;
    }
}