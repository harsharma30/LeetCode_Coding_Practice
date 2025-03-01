class Solution {
    public int[] applyOperations(int[] nums) {
        int l = nums.length;
        int[] arr = new int[l];
        int s = 0;
        int e = l - 1;

        for (int i = 0; i < l; i++) {
            if (nums[i] == 0) {
                arr[e] = 0;
                e--;
            } 
            else if (i < l - 1 && nums[i] == nums[i + 1]) { // Avoid out-of-bounds error
                arr[s] = nums[i] * 2;
                nums[i + 1] = 0;
                s++;
            } 
            else if (i == l - 1 || nums[i] != nums[i + 1]) { // Ensure last element is processed
                arr[s] = nums[i];
                s++;
            }
        }

        return arr; // Return statement added
    }
}
