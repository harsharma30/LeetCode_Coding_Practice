import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind = 0;
        int start = m;

        for (int i = start; i < nums1.length; i++) {
            nums1[i] = nums2[ind++];
        }

        Arrays.sort(nums1);
    }
}